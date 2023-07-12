package ccserver.dao;

import ccserver.entity.jwt.ERole;
import ccserver.entity.jwt.Role;
import ccserver.util.SessionUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import jakarta.persistence.RollbackException;
import java.util.List;

@Component
public class RoleDAO extends EntityDAO<Role> {

    private final SessionUtil sessionUtil;


    @Autowired
    public RoleDAO(SessionUtil sessionUtil) {
        super.setSessionUtil(sessionUtil);
        this.sessionUtil = sessionUtil;
    }

    public Role findByName(ERole name) {
        List<Role> entities;

        Session session = sessionUtil.openSession();
        Transaction transaction = session.beginTransaction();

        try {
            entities = session.createQuery("from " + super.getEntityClass().getName()+
                        " R where R.name = :name", Role.class).setParameter("name", name).list();

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

        return entities.size() == 1 ? entities.get(0) : new Role();
    }

}