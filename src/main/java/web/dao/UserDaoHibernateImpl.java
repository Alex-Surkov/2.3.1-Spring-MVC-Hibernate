package web.dao;


import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import web.model.User;
import web.util.Util;


import java.util.List;

public class UserDaoHibernateImpl implements UserDao {
//
//    @Override
//    public void createUsersTable() {
//
//        try (Session session = Util.getSession()) {
//            session.beginTransaction();
//            session.createNativeQuery("CREATE TABLE IF NOT EXISTS users (id INT PRIMARY KEY AUTO_INCREMENT, name VARCHAR(50), lastName VARCHAR(50), age TINYINT)").executeUpdate();
//            session.getTransaction().commit();
//
//        } catch (HibernateException e) {
//            throw new RuntimeException(e.getMessage(), e.getCause());
//
//        }
//    }
//
//    @Override
//    public void dropUsersTable() {
//        try (Session session = Util.getSession()) {
//            session.beginTransaction();
//            session.createNativeQuery("DROP TABLE IF EXISTS users").executeUpdate();
//            session.getTransaction().commit();
//        } catch (HibernateException e) {
//            throw new RuntimeException(e.getMessage(), e.getCause());
//        }
//    }
//
//    @Override
//    public void saveUser(String name, String lastName, byte age) {
//        try (Session session = Util.getSession()) {
//            User user = new User(name, lastName, age);
//            session.beginTransaction();
//            session.persist(user);
//            session.getTransaction().commit();
//        } catch (HibernateException e) {
//            throw new RuntimeException(e.getMessage(), e.getCause());
//        }
//    }
//
//    @Override
//    public void removeUserById(long id) {
//        try (Session session = Util.getSession()) {
//            session.beginTransaction();
//            User user = session.get(User.class, id);
//            if (user != null) {
//                session.remove(user);
//            }
//            session.getTransaction().commit();
//        } catch (HibernateException e) {
//            throw new RuntimeException(e.getMessage(), e.getCause());
//        }
//    }
//
//    @Override
//    public List<User> getAllUsers() {
//        try (Session session = Util.getSession()) {
//            session.beginTransaction();
//            List<User> users = session.createQuery("FROM User", User.class).getResultList();
//            session.getTransaction().commit();
//            return users;
//        } catch (HibernateException e) {
//            throw new RuntimeException(e.getMessage(), e.getCause());
//        }
//    }
//
//    @Override
//    public void cleanUsersTable() {
//        try (Session session = Util.getSession()) {
//            session.beginTransaction();
//            session.createQuery("DELETE FROM User").executeUpdate();
//            session.getTransaction().commit();
//        } catch (HibernateException e) {
//            throw new RuntimeException(e.getMessage(), e.getCause());
//        }
//    }
@Override
public void createUsersTable() {
    EntityManager entityManager = Util.getEntityManager();
    EntityTransaction transaction = null;

    try {
        transaction = entityManager.getTransaction();
        transaction.begin();

        entityManager.createNativeQuery(
                "CREATE TABLE IF NOT EXISTS users (id INT PRIMARY KEY AUTO_INCREMENT, name VARCHAR(50), lastName VARCHAR(50), age TINYINT)"
        ).executeUpdate();

        transaction.commit();
    } catch (Exception e) {
        if (transaction != null && transaction.isActive()) {
            transaction.rollback();
        }
        throw new RuntimeException(e.getMessage(), e.getCause());
    } finally {
        if (entityManager != null && entityManager.isOpen()) {
            entityManager.close();
        }
    }
}

    @Override
    public void dropUsersTable() {
        EntityManager entityManager = Util.getEntityManager();
        EntityTransaction transaction = null;

        try {
            transaction = entityManager.getTransaction();
            transaction.begin();

            entityManager.createNativeQuery("DROP TABLE IF EXISTS users").executeUpdate();

            transaction.commit();
        } catch (Exception e) {
            if (transaction != null && transaction.isActive()) {
                transaction.rollback();
            }
            throw new RuntimeException(e.getMessage(), e.getCause());
        } finally {
            if (entityManager != null && entityManager.isOpen()) {
                entityManager.close();
            }
        }
    }

    @Override
    public void saveUser(String name, String lastName, byte age) {
        EntityManager entityManager = Util.getEntityManager();
        EntityTransaction transaction = null;

        try {
            transaction = entityManager.getTransaction();
            transaction.begin();

            User user = new User(name, lastName, age);
            entityManager.persist(user);

            transaction.commit();
        } catch (Exception e) {
            if (transaction != null && transaction.isActive()) {
                transaction.rollback();
            }
            throw new RuntimeException(e.getMessage(), e.getCause());
        } finally {
            if (entityManager != null && entityManager.isOpen()) {
                entityManager.close();
            }
        }
    }

    @Override
    public void removeUserById(long id) {
        EntityManager entityManager = Util.getEntityManager();
        EntityTransaction transaction = null;

        try {
            transaction = entityManager.getTransaction();
            transaction.begin();

            User user = entityManager.find(User.class, id);
            if (user != null) {
                entityManager.remove(user);
            }

            transaction.commit();
        } catch (Exception e) {
            if (transaction != null && transaction.isActive()) {
                transaction.rollback();
            }
            throw new RuntimeException(e.getMessage(), e.getCause());
        } finally {
            if (entityManager != null && entityManager.isOpen()) {
                entityManager.close();
            }
        }
    }

    @Override
    public List<User> getAllUsers() {
        EntityManager entityManager = Util.getEntityManager();
        EntityTransaction transaction = null;

        try {
            transaction = entityManager.getTransaction();
            transaction.begin();

            List<User> users = entityManager.createQuery("FROM User", User.class).getResultList();

            transaction.commit();
            return users;
        } catch (Exception e) {
            if (transaction != null && transaction.isActive()) {
                transaction.rollback();
            }
            throw new RuntimeException(e.getMessage(), e.getCause());
        } finally {
            if (entityManager != null && entityManager.isOpen()) {
                entityManager.close();
            }
        }
    }

    @Override
    public void cleanUsersTable() {
        EntityManager entityManager = Util.getEntityManager();
        EntityTransaction transaction = null;

        try {
            transaction = entityManager.getTransaction();
            transaction.begin();

            entityManager.createQuery("DELETE FROM User").executeUpdate();

            transaction.commit();
        } catch (Exception e) {
            if (transaction != null && transaction.isActive()) {
                transaction.rollback();
            }
            throw new RuntimeException(e.getMessage(), e.getCause());
        } finally {
            if (entityManager != null && entityManager.isOpen()) {
                entityManager.close();
            }
        }
    }
}
