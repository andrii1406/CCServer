package ccserver.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Kstat implements IEntity<Kstat> {

    @Id
    private Long id;

    private String stat;


    public Kstat() {}

    public Kstat(Long id, String stat) {
        this.id = id;
        this.stat = stat;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStat() {
        return stat;
    }

    public void setStat(String stat) {
        this.stat = stat;
    }

    @Override
    public void copyFieldsFrom(Kstat entity) {
        if (entity != null) {
            this.id = entity.getId();
            this.stat = entity.getStat();
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

    @Override
    public String toString() {
        return "Kstat{" +
                "id=" + id +
                ", stat='" + stat + '\'' +
                '}';
    }

}
