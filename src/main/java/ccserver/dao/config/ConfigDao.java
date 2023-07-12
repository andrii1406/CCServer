package ccserver.dao.config;

import ccserver.dao.EntityDAO;
import ccserver.entity.IEntity;

public class ConfigDao<E extends IEntity<E>> {

    private EntityDAO<E> eDAO;


    public EntityDAO<E> getDAO() {
        return eDAO;
    }

    public void setDAO(EntityDAO<E> eDAO) {
        this.eDAO = eDAO;
    }

}
