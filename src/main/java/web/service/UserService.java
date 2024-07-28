package web.service;


import web.model.User;

import javax.transaction.Transactional;
import java.util.List;

public interface UserService {

    void saveUser(String name, String lastName, int age);

    void removeUserById(long id);

    List<User> getAllUsers();

    void cleanUsersTable();

    @Transactional
    void updateName(long id, String newName);

    @Transactional
    void updateLastname(long id, String newLastname);

    @Transactional
    void updateAge(long id, int newAge);

    @Transactional
    User getUser(long id);
}
