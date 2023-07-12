package ccserver.dao;

import ccserver.entity.PrihRash;
import ccserver.util.SessionUtil;
import jakarta.persistence.RollbackException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.List;

@Component
public class PrihRashDAO extends EntityDAO<PrihRash> {

    private final SessionUtil sessionUtil;


    @Autowired
    public PrihRashDAO(SessionUtil sessionUtil) {
        super.setSessionUtil(sessionUtil);
        this.sessionUtil = sessionUtil;
    }


    public List<PrihRash> readByPrAndNpAndDt(Long pr_id, Long npo, Date dtB, Date dtE) throws NullPointerException, ClassCastException, SecurityException, IllegalStateException, RollbackException {
        List<PrihRash> entities;

        Session session = sessionUtil.openSession();
        Transaction transaction = session.beginTransaction();

        try {
            entities = session.createQuery("select E from PrihRash E " +
                            "where E.fl = false and E.pr.id = :pr_id and E.npo = :npo " +
                            "and (E.dt between :dtB and :dtE) order by E.dts ", PrihRash.class)
                    .setParameter("pr_id", pr_id)
                    .setParameter("npo", npo)
                    .setParameter("dtB", dtB)
                    .setParameter("dtE", dtE)
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
