package ccserver.mapper;

public interface EntityMapper<E, D> {

    D mapToDTO(E e);

    E mapToEntity(D d);

}