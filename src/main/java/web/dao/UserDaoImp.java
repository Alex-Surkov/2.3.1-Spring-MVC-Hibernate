package web.dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.PlatformTransactionManager;
import web.model.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
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
    public void createUsersTable() {

    }

    @Override
    @Transactional
    public void dropUsersTable() {

    }

    @Override
    @Transactional
    public void saveUser(String name, String lastName, byte age) {
    }

    @Override
    @Transactional
    public void removeUserById(long id) {
    }

    @Override
    @Transactional
    public List<User> getAllUsers() {
        return manager.createQuery("select u from User u", User.class).getResultList();
    }

    @Override
    @Transactional
    public void cleanUsersTable() {
    }
}
