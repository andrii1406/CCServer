package ccserver.entity;

import jakarta.persistence.Id;
import jakarta.persistence.Entity;

@Entity
public class Operation implements IEntity<Operation> {

    @Id
    private Long id;

    private String opr;


    public Operation() {}

    public Operation(Long id, String opr) {
        this.id = id;
        this.opr = opr;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOpr() {
        return opr;
    }

    public void setOpr(String opr) {
        this.opr = opr;
    }

    @Override
    public String toString() {
        return "Operation{" +
                "id=" + id +
                ", opr='" + opr + '\'' +
                '}';
    }

    @Override
    public void copyFieldsFrom(Operation entity) {
        if (entity != null) {
            this.id = entity.getId();
            this.opr = entity.getOpr();
        }
    }

    @Override
    public Long get_ID() {
        return id;
    }

    @Override
    public Boolean isDeleted() {
        return false;
    }

    @Override
    public void makeDeleted() {}

}
