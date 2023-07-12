package ccserver.dao;

import ccserver.entity.Kurses;
import ccserver.entity.KursesPublic;
import ccserver.util.SessionUtil;
import jakarta.persistence.OptimisticLockException;
import jakarta.persistence.RollbackException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Component
public class KursesDAO extends EntityDAO<Kurses> {

    private final SessionUtil sessionUtil;


    @Autowired
    public KursesDAO(SessionUtil sessionUtil) {
        super.setSessionUtil(sessionUtil);
        this.sessionUtil = sessionUtil;
    }

    @Override
    public List<Kurses> create(List<Kurses> entities) throws NullPointerException, ClassCastException, IllegalStateException, RollbackException, OptimisticLockException {

        Session session = sessionUtil.openSession();
        Transaction transaction = session.beginTransaction();

        List<Kurses> resEntities = new ArrayList<>();
        try {
            entities.forEach(entity -> {
                session.persist(entity);
                resEntities.add(entity);

                List<KursesPublic> kpList = session.createQuery(
                        "select E from KursesPublic E where E.k.fl = false and " +
                        "E.k.tv = :tv and E.k.pp.id = :ppId and E.k.vl.id = :vlId", KursesPublic.class)
                        .setParameter("tv", entity.getTv())
                        .setParameter("ppId", entity.getPp().getId())
                        .setParameter("vlId", entity.getVl().getId())
                        .getResultList();

                if (kpList.size() > 0) {
                    KursesPublic kp = kpList.get(0);
                    kp.setK(entity);
                    kp.setU(new Date());
                }
                else {
                    session.persist(new KursesPublic(null, entity, new Date()));
                }
            });
            transaction.commit();
            session.close();
        }
        catch (NullPointerException | ClassCastException | IllegalStateException |
               IllegalArgumentException | RollbackException | OptimisticLockException e) {
            if (transaction.isActive()) {
                transaction.rollback();
                session.close();
            }
            e.printStackTrace();
            throw(e);
        }

        return resEntities;
    }

    public void deleteKursesByNpAndDt(Long np, Date dtB, Date dtE) throws NullPointerException, ClassCastException, SecurityException, IllegalStateException, RollbackException {
        Session session = sessionUtil.openSession();
        Transaction transaction = session.beginTransaction();

        try {
            session.createMutationQuery(
                            "update Kurses E set E.fl = true where E.np = :np " +
                                    "and (E.dt between :dtB and :dtE) ")
                    .setParameter("np", np)
                    .setParameter("dtB", dtB)
                    .setParameter("dtE", dtE)
                    .executeUpdate();

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
    }

}