package ccserver.dao;

import ccserver.entity.KursesPublic;
import ccserver.util.SessionUtil;
import jakarta.persistence.RollbackException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
public class KursesPublicDAO extends EntityDAO<KursesPublic> {

    private final SessionUtil sessionUtil;

    @Autowired
    public KursesPublicDAO(SessionUtil sessionUtil) {
        super.setSessionUtil(sessionUtil);
        this.sessionUtil = sessionUtil;
    }

    public List<KursesPublic> readKursesPublicPriemsAndProdsByTv(Long tv) throws NullPointerException, ClassCastException, SecurityException, IllegalStateException, RollbackException {
        List<KursesPublic> entities;

        Session session = sessionUtil.openSession();
        Transaction transaction = session.beginTransaction();

        try {
            entities = session.createQuery(
                            "select E from KursesPublic E where E.k.fl = false and E.k.tv = :tv " +
                                    "and (E.k.pp.id = 0 or E.k.pp.id = 1) " +
                                    "order by E.k.vl.id", KursesPublic.class)
                    .setParameter("tv", tv)
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
            throw (e);
        }

        return entities;
    }

}