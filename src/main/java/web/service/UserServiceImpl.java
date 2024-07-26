package web.service;


import org.hibernate.HibernateException;
import web.dao.UserDao;
import web.dao.UserDaoHibernateImpl;
import web.model.User;

import java.util.List;

public class UserServiceImpl implements UserService {

    UserDao dao = new UserDaoHibernateImpl();

    public void createUsersTable() throws HibernateException {
        dao.createUsersTable();
    }

    public void dropUsersTable() throws HibernateException {
        dao.dropUsersTable();
    }

    public void saveUser(String name, String lastName, byte age) throws HibernateException {
        dao.saveUser(name, lastName, age);
    }

    public void removeUserById(long id) throws HibernateException {
        dao.removeUserById(id);
    }

    public List<User> getAllUsers() throws HibernateException {
        return dao.getAllUsers();
    }

    public void cleanUsersTable() throws HibernateException {
        dao.cleanUsersTable();
    }
}
