package ccserver.entity;

import jakarta.persistence.Id;
import jakarta.persistence.Entity;

@Entity
public class Obmen implements IEntity<Obmen> {

    @Id
    private Long id;

    private String obm;


    public Obmen() {}

    public Obmen(Long id, String obm) {
        this.id = id;
        this.obm = obm;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getObm() {
        return obm;
    }

    public void setObm(String obm) {
        this.obm = obm;
    }

    @Override
    public String toString() {
        return "Obmen{" +
                "id=" + id +
                ", obm='" + obm + '\'' +
                '}';
    }

    @Override
    public void copyFieldsFrom(Obmen entity) {
        if (entity != null) {
            this.id = entity.getId();
            this.obm = entity.getObm();
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
