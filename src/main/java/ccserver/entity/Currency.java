package ccserver.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Currency implements IEntity<Currency> {

    @Id
    private Long id;

    private String vl;


    public Currency() {}

    public Currency(Long id, String vl) {
        this.id = id;
        this.vl = vl;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getVl() {
        return vl;
    }

    public void setVl(String vl) {
        this.vl = vl;
    }

    @Override
    public String toString() {
        return "Currency{" +
                "id=" + id +
                ", vl='" + vl + '\'' +
                '}';
    }

    @Override
    public void copyFieldsFrom(Currency entity) {
        if (entity != null) {
            this.id = entity.getId();
            this.vl = entity.getVl();
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
