package ccserver.dao;

import ccserver.entity.PriemProd;
import ccserver.util.SessionUtil;
import jakarta.persistence.RollbackException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.List;

@Component
public class PriemProdDAO extends EntityDAO<PriemProd> {

    private final SessionUtil sessionUtil;


    @Autowired
    public PriemProdDAO(SessionUtil sessionUtil) {
        super.setSessionUtil(sessionUtil);
        this.sessionUtil = sessionUtil;
    }

    public List<PriemProd> readByPpAndNpAndDt(Long pp_id, Long np, Date dtB, Date dtE) throws NullPointerException, ClassCastException, SecurityException, IllegalStateException, RollbackException {
        List<PriemProd> entities;

        Session session = sessionUtil.openSession();
        Transaction transaction = session.beginTransaction();

        try {
            entities = session.createQuery("select E from PriemProd E " +
                            "where E.fl = false and E.pp.id = :pp_id and E.np = :np " +
                            "and (E.dt between :dtB and :dtE) order by E.dts ", PriemProd.class)
                    .setParameter("pp_id", pp_id)
                    .setParameter("np", np)
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
