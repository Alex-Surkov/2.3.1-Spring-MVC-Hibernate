package web.dao;

import org.springframework.stereotype.Component;
import web.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@Component
public class UserDaoImp implements UserDao {

    @PersistenceContext
    private EntityManager manager;


    @Override
    @Transactional
    public void saveUser(String name, String lastName, int age) {
        manager.persist(new User(name, lastName, age));
    }

    @Override
    @Transactional
    public void removeUserById(long id) {
        TypedQuery<User> typedQuery = manager.createQuery("select u from User u where u.id = :id", User.class);
        typedQuery.setParameter("id", id);
        manager.remove(typedQuery.getResultList().stream().findAny().orElse(null));
    }

    @Override
    @Transactional
    public List<User> getAllUsers() {
        return manager.createQuery("select u from User u", User.class).getResultList();
    }

    @Override
    public User getUser(long id) {
        TypedQuery<User> typedQuery = manager.createQuery("select u from User u where u.id = :id", User.class);
        typedQuery.setParameter("id", id);
        return typedQuery.getSingleResult();

    }

    @Override
    @Transactional
    public void cleanUsersTable() {
    }

    @Transactional
    @Override
    public void updateName(long id, String newName) {
        TypedQuery<User> typedQuery = manager.createQuery("select u from User u where u.id = :id", User.class);
        typedQuery.setParameter("id", id);
        typedQuery.getSingleResult().setName(newName);

    }

    @Transactional
    @Override
    public void updateLastname(long id, String newLastname) {
        TypedQuery<User> typedQuery = manager.createQuery("select u from User u where u.id = :id", User.class);
        typedQuery.setParameter("id", id);
        typedQuery.getSingleResult().setLastName(newLastname);
    }

    @Transactional
    @Override
    public void updateAge(long id, int newAge) {
        TypedQuery<User> typedQuery = manager.createQuery("select u from User u where u.id = :id", User.class);
        typedQuery.setParameter("id", id);
        typedQuery.getSingleResult().setAge(newAge);
    }


}
