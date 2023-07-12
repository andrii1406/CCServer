package ccserver.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Filial implements IEntity<Filial> {

    @Id
    private Long id;

    private Long tv;

    private String cn;


    public Filial() {}

    public Filial(Long id, Long tv, String cn) {
        this.id = id;
        this.tv = tv;
        this.cn = cn;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getTv() {
        return tv;
    }

    public void setTv(Long tv) {
        this.tv = tv;
    }

    public String getCn() {
        return cn;
    }

    public void setCn(String cn) {
        this.cn = cn;
    }

    @Override
    public String toString() {
        return "Filial{" +
                "id=" + id +
                ", tv=" + tv +
                ", cn='" + cn + '\'' +
                '}';
    }

    @Override
    public void copyFieldsFrom(Filial entity) {
        if (entity != null) {
            this.id = entity.getId();
            this.cn = entity.getCn();
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
