package web.service;


import org.hibernate.HibernateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import web.dao.UserDao;
import web.model.User;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {


    private final UserDao dao;

    @Autowired
    UserServiceImpl(UserDao dao) {
        this.dao = dao;
    }

    @Transactional
    public void saveUser(String name, String lastName, int age) throws HibernateException {
        dao.saveUser(name, lastName, age);
    }

    @Transactional
    public void removeUserById(long id) throws HibernateException {
        dao.removeUserById(id);
    }

    @Transactional
    public List<User> getAllUsers() throws HibernateException {
        return dao.getAllUsers();
    }


    @Transactional
    @Override
    public User getUser(long id) {
        return dao.getUser(id);
    }

    @Transactional
    @Override
    public void updateUser(long id, String newName, int newAge, String newSurname) {
        dao.updateUser(id, newName, newAge, newSurname);
    }
}
