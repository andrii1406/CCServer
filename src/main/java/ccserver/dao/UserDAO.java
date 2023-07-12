package ccserver.dao;

import ccserver.entity.jwt.User;
import ccserver.util.SessionUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import jakarta.persistence.NoResultException;
import jakarta.persistence.RollbackException;
import java.util.List;

@Component
public class UserDAO extends EntityDAO<User> {

    private final SessionUtil sessionUtil;


    @Autowired
    public UserDAO(SessionUtil sessionUtil) {
        super.setSessionUtil(sessionUtil);
        this.sessionUtil = sessionUtil;
    }

    public User findByUsername(String username) {
        List<User> entities;

        Session session = sessionUtil.openSession();
        Transaction transaction = session.beginTransaction();

        try {
            entities = session.createQuery("select E from User E " +
                    "where E.username = :username", User.class)
                    .setParameter("username", username)
                    .getResultList();

            transaction.commit();
            session.close();
        } catch (NullPointerException | ClassCastException | SecurityException |
                 IllegalStateException | RollbackException | NoResultException e) {
            if (transaction.isActive()) {
                transaction.rollback();
                session.close();
            }
            e.printStackTrace();
            throw(e);
        }

        return entities.size() == 1 ? entities.get(0) : new User();
    }

    public User findByEmail(String email) {
        List<User> entities;

        Session session = super.getSessionUtil().openSession();
        Transaction transaction = session.beginTransaction();

        try {
            entities = session.createQuery("select E from User E " +
                    "where E.email = :email", User.class)
                    .setParameter("email", email)
                    .getResultList();
            transaction.commit();
            session.close();
        } catch (NullPointerException | ClassCastException | SecurityException |
                 IllegalStateException | RollbackException e) {
            if (transaction.isActive()) {
                transaction.rollback();
                session.close();
            }
            e.printStackTrace();
            throw(e);
        }

        return entities.size() == 1 ? entities.get(0) : new User();
    }

    public Boolean existsByUsername(String username) {
        return findByUsername(username).getId() != null;
    }

    public Boolean existsByEmail(String email) {
        return findByEmail(email).getId() != null;
    }

}