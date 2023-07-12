package ccserver.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

public interface IEntity<E> {

    void copyFieldsFrom(E entity);

    @JsonIgnore
    Long get_ID();

    @JsonIgnore
    Boolean isDeleted();

    void makeDeleted();

}