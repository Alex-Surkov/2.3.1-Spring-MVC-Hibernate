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

    @Autowired
    UserDao dao;

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
    public void cleanUsersTable() throws HibernateException {
        dao.cleanUsersTable();
    }

    @Transactional
    @Override
    public void updateName(long id, String newName) {
        dao.updateName(id, newName);

    }

    @Transactional
    @Override
    public void updateLastname(long id, String newLastname) {
        dao.updateLastname(id, newLastname);
    }

    @Transactional
    @Override
    public void updateAge(long id, int newAge) {
        dao.updateAge(id, newAge);
    }

    @Override
    public User getUser(long id) {
        return dao.getUser(id);
    }
}
