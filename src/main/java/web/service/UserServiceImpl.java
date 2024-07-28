package web.service;


import org.hibernate.HibernateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import web.dao.UserDao;
import web.dao.UserDaoImp;
import web.model.User;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserDao dao;

    @Transactional
    public void createUsersTable() throws HibernateException {
        dao.createUsersTable();
    }
    @Transactional
    public void dropUsersTable() throws HibernateException {
        dao.dropUsersTable();
    }

    @Transactional
    public void saveUser(String name, String lastName, byte age) throws HibernateException {
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
}
