package ccserver.dao;

import ccserver.entity.IEntity;
import ccserver.util.SessionUtil;
import jakarta.persistence.OptimisticLockException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import jakarta.persistence.RollbackException;
import java.lang.reflect.InvocationTargetException;
import java.util.*;

public class EntityDAO<E extends IEntity<E>> {

    private Class<E> entityClass;

    private SessionUtil sessionUtil;


    EntityDAO() {}

    public List<E> create(List<E> entities) throws NullPointerException, ClassCastException, IllegalStateException, RollbackException, OptimisticLockException {

        Session session = sessionUtil.openSession();
        Transaction transaction = session.beginTransaction();

        List<E> resEntities = new ArrayList<>();
        try {
            entities.forEach(entity -> {
                session.persist(entity);
                resEntities.add(entity);
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

    public E create(E entity) throws NullPointerException, ClassCastException, IllegalStateException, RollbackException, OptimisticLockException {
        List<E> resList = create(new ArrayList<>(Collections.singleton(entity)));
        return resList.get(0);
    }

    public List<E> readAll() throws NullPointerException, ClassCastException, SecurityException, IllegalStateException, RollbackException {
        List<E> entities;

        Session session = sessionUtil.openSession();
        Transaction transaction = session.beginTransaction();

        try {
            entities = session.createQuery(
                    "select E from " + entityClass.getName() + " E", entityClass).getResultList();

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

        return entities;
    }

    public E read(Long id) throws NullPointerException, ClassCastException, InstantiationException, IllegalAccessException, NoSuchMethodException, SecurityException, InvocationTargetException, IllegalStateException, RollbackException {
        E entity;

        Session session = sessionUtil.openSession();
        Transaction transaction = session.beginTransaction();

        try {
            entity = session.get(entityClass, id);
            transaction.commit();
            session.close();

            if (entity == null) {
                entity = entityClass.getDeclaredConstructor().newInstance();
            }
        }
        catch(NullPointerException | ClassCastException | NoSuchMethodException | SecurityException |
              InvocationTargetException | IllegalStateException | RollbackException e) {
            if (transaction.isActive()) {
                transaction.commit();
                session.close();
            }
            e.printStackTrace();
            throw(e);
        }

        return entity;
    }

    public List<E> readByNpAndDt(Long np, Date dtB, Date dtE) throws NullPointerException, ClassCastException, SecurityException, IllegalStateException, RollbackException {
        List<E> entities;

        Session session = sessionUtil.openSession();
        Transaction transaction = session.beginTransaction();

        try {
            entities = session.createQuery("select E from " + entityClass.getName() +
                            " E where E.fl = false and E.np = :np " +
                            "and (E.dt between :dtB and :dtE) order by E.vl.id", entityClass)
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

    public E update(E entityNew) throws NullPointerException, ClassCastException, InstantiationException, IllegalAccessException, NoSuchMethodException, SecurityException, InvocationTargetException, IllegalStateException, RollbackException {
        E entity;

        Session session = sessionUtil.openSession();
        Transaction transaction = session.beginTransaction();

        try {
            Long id = entityNew.get_ID();
            entity = session.get(entityClass, id);

            if (entity == null) {
                entity = entityClass.getDeclaredConstructor().newInstance();
            }
            else {
                entity.copyFieldsFrom(entityNew);
                entity = session.merge(entity);
            }
            transaction.commit();
            session.close();
        }
        catch (NullPointerException | ClassCastException | NoSuchMethodException | SecurityException |
               InvocationTargetException | IllegalStateException | RollbackException e) {
            if (transaction.isActive()) {
                transaction.rollback();
                session.close();
            }
            e.printStackTrace();
            throw(e);
        }

        return entity;
    }

    public E delete(E entity) throws NullPointerException, ClassCastException, InstantiationException, IllegalAccessException, NoSuchMethodException, SecurityException, InvocationTargetException, IllegalStateException, RollbackException {

        Session session = sessionUtil.openSession();
        Transaction transaction = session.beginTransaction();

        try {
            Long id = entity.get_ID();
            entity = session.get(entityClass, id);

            if (entity == null) {
                entity = entityClass.getDeclaredConstructor().newInstance();
            }
            else
            if (!entity.isDeleted()) {
                entity.makeDeleted();
                entity = session.merge(entity);
            }
            transaction.commit();
            session.close();
        }
        catch(NullPointerException | ClassCastException | NoSuchMethodException | SecurityException |
              InvocationTargetException | IllegalStateException | RollbackException e) {
            if (transaction.isActive()) {
                transaction.rollback();
                session.close();
            }
            e.printStackTrace();
            throw(e);
        }

        return entity;
    }

    public void setClass(Class<E> entityClass) {
        this.entityClass = entityClass;
    }

    public Class<E> getEntityClass() {
        return entityClass;
    }

    public void setSessionUtil(SessionUtil sessionUtil) {
        this.sessionUtil = sessionUtil;
    }

    SessionUtil getSessionUtil() {
        return this.sessionUtil;
    }

}