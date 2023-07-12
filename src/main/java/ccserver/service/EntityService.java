package ccserver.service;

import ccserver.dao.EntityDAO;
import ccserver.entity.IEntity;
import ccserver.mapper.EntityMapper;
import java.lang.reflect.InvocationTargetException;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class EntityService <E extends IEntity<E>, D> {

    private EntityDAO<E> eDAO;

    private EntityMapper<E, D> eMapper;


    public D create(D dto) throws NullPointerException, ClassCastException, InstantiationException, IllegalAccessException {
        return eMapper.mapToDTO(eDAO.create(eMapper.mapToEntity(dto)));
    }

    public List<D> create(List<D> dtoList) throws NullPointerException, ClassCastException, InstantiationException, IllegalAccessException {
        List<E> entityList = dtoList
                .stream()
                .map(eMapper::mapToEntity)
                .toList();

        return eDAO
                .create(entityList)
                .stream()
                .map(eMapper::mapToDTO)
                .collect(Collectors.toList());
    }

    public List<D> readAll() throws NullPointerException, ClassCastException {
        return eDAO
                .readAll()
                .stream()
                .map(eMapper::mapToDTO)
                .collect(Collectors.toList());
    }

    public List<D> readByNpAndDt(Long np, Date dtB, Date dtE) throws NullPointerException, ClassCastException {
        return eDAO
                .readByNpAndDt(np, dtB, dtE)
                .stream()
                .map(eMapper::mapToDTO)
                .collect(Collectors.toList());
    }

    public D read(Long id) throws NullPointerException, ClassCastException, InstantiationException, IllegalAccessException, InvocationTargetException, NoSuchMethodException {
        return eMapper.mapToDTO(eDAO.read(id));
    }

    public D update(D dto) throws NullPointerException, ClassCastException, InstantiationException, IllegalAccessException, InvocationTargetException, NoSuchMethodException {
        return eMapper.mapToDTO(eDAO.update(eMapper.mapToEntity(dto)));
    }

    public D delete(D dto) throws NullPointerException, ClassCastException, InstantiationException, IllegalAccessException, InvocationTargetException, NoSuchMethodException {
        return eMapper.mapToDTO(eDAO.delete(eMapper.mapToEntity(dto)));
    }

    public void setDAO(EntityDAO<E> eDAO) {
        this.eDAO = eDAO;
    }

    public EntityDAO<E> getDAO() {
        return this.eDAO;
    }

    public void setMapper(EntityMapper<E, D> eMapper) {
        this.eMapper = eMapper;
    }

    public EntityMapper<E, D> getMapper() {
        return this.eMapper;
    }

}
