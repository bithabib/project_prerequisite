package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.HibernateUtil;
import org.hibernate.Session;

import javax.transaction.SystemException;
import javax.transaction.Transaction;
import java.util.List;

public class UserDaoHibernateImpl implements UserDao {
    public UserDaoHibernateImpl() {

    }


    @Override
    public void createUsersTable() {
        String sql = "CREATE TABLE IF NOT EXISTS users (" +
                "id BIGINT PRIMARY KEY AUTO_INCREMENT, " +
                "name VARCHAR(50), " +
                "lastName VARCHAR(50), " +
                "age TINYINT)";
        executeUpdate(sql);

    }

    private void executeUpdate(String sql) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = (Transaction) session.beginTransaction();
            session.createNativeQuery(sql).executeUpdate(); // Hibernate runs the SQL
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                try {
                    transaction.rollback();
                } catch (SystemException ex) {
                    throw new RuntimeException(ex);
                }
            }
            e.printStackTrace();
        }
    }

    @Override
    public void dropUsersTable() {
        executeUpdate("DROP TABLE IF EXISTS users");
    }

    @Override
    public void saveUser(String name, String lastName, byte age) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = (Transaction) session.beginTransaction();
            session.persist(new User(name, lastName, age));
            transaction.commit();
            System.out.println("User with name – " + name + " added to the database");
        } catch (Exception e) {
            if (transaction != null) {
                try {
                    transaction.rollback();
                } catch (SystemException ex) {
                    throw new RuntimeException(ex);
                }
            }
            e.printStackTrace();
        }

    }

    @Override
    public void removeUserById(long id) {Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = (Transaction) session.beginTransaction();
            User user = session.get(User.class, id);
            if (user != null) session.remove(user);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                try {
                    transaction.rollback();
                } catch (SystemException ex) {
                    throw new RuntimeException(ex);
                }
            }
            e.printStackTrace();
        }


    }

    @Override
    public List<User> getAllUsers() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("FROM User", User.class).list();
        }
    }

    @Override
    public void cleanUsersTable() {
        executeUpdate("TRUNCATE TABLE users");
    }
}
