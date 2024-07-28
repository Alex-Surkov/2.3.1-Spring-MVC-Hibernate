package web.dao;


import web.model.User;

import java.util.List;

public interface UserDao {

    void saveUser(String name, String lastName, int age);

    void removeUserById(long id);

    List<User> getAllUsers();

    User getUser(long id);

    void cleanUsersTable();

    void updateName(long id, String newName);

    void updateLastname(long id, String newLastname);

    void updateAge(long id, int newAge);


}
