package ccserver.service.config;

import ccserver.entity.IEntity;
import ccserver.service.EntityService;

public class ServiceConfig <E extends IEntity<E>, D> {

    EntityService<E, D> eService;


    public void setService(EntityService<E, D> eService) {
        this.eService = eService;
    }

    public EntityService<E, D> getService() {
        return eService;
    }

}