package ccserver.controller.config;

import java.lang.reflect.InvocationTargetException;
import java.util.Date;
import java.util.List;
import ccserver.entity.IEntity;
import ccserver.service.EntityService;

public class EntityController<E extends IEntity<E>, D> {

    private EntityService<E, D> eService;


    public D create(D dto) throws NullPointerException, ClassCastException, InstantiationException, IllegalAccessException {
        return eService.create(dto);
    }

    public List<D> create(List<D> dtoList) throws NullPointerException, ClassCastException, InstantiationException, IllegalAccessException {
        return eService.create(dtoList);
    }

    public List<D> readAll() throws NullPointerException, ClassCastException {
        return eService.readAll();
    }

    public D read(Long id) throws NullPointerException, ClassCastException, InstantiationException, IllegalAccessException, InvocationTargetException, NoSuchMethodException {
        return eService.read(id);
    }

    public List<D> readByNpAndDt(Long np, Date dtB, Date dtE) throws NullPointerException, ClassCastException {
        return eService.readByNpAndDt(np, dtB, dtE);
    }

    public D update(D dto) throws NullPointerException, ClassCastException, InstantiationException, IllegalAccessException, InvocationTargetException, NoSuchMethodException {
        return eService.update(dto);
    }

    public D delete(D dto) throws NullPointerException, ClassCastException, InstantiationException, IllegalAccessException, InvocationTargetException, NoSuchMethodException {
        return eService.delete(dto);
    }

    public void setService(EntityService<E, D> eService) {
        this.eService = eService;
    }

    public EntityService<E, D>getService() {
        return this.eService;
    }

}