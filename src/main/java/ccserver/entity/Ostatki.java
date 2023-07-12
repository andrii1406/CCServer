package ccserver.entity;

import jakarta.persistence.*;
import java.util.Date;

@Entity
public class Ostatki implements IEntity<Ostatki> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long np;

    @ManyToOne
    private Currency vl;

    private Double ost;

    private Date dt;

    private Boolean fl;


    public Ostatki() {}

    public Ostatki(Long id, Long np, Currency vl, Double ost, Date dt, Boolean fl) {
        this.id = id;
        this.np = np;
        this.vl = vl;
        this.ost = ost;
        this.dt = dt;
        this.fl = fl;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getNp() {
        return np;
    }

    public void setNp(Long np) {
        this.np = np;
    }

    public Currency getVl() {
        return vl;
    }

    public void setVl(Currency vl) {
        this.vl = vl;
    }

    public Double getOst() {
        return ost;
    }

    public void setOst(Double ost) {
        this.ost = ost;
    }

    public Date getDt() {
        return dt;
    }

    public void setDt(Date dt) {
        this.dt = dt;
    }

    public Boolean getFl() {
        return fl;
    }

    public void setFl(Boolean fl) {
        this.fl = fl;
    }

    @Override
    public String toString() {
        return "Ostatki{" +
                "id=" + id +
                ", np=" + np +
                ", vl=" + vl +
                ", ost=" + ost +
                ", dt=" + dt +
                ", fl=" + fl +
                '}';
    }

    @Override
    public void copyFieldsFrom(Ostatki entity) {
        if (entity != null) {
            if(entity.getNp() != null) this.np = entity.getNp();
            if(entity.getVl() != null) this.vl = entity.getVl();
            if(entity.getOst() != null) this.ost = entity.getOst();
            if(entity.getDt() != null) this.dt = entity.getDt();
            if(entity.getFl() != null) this.fl = entity.getFl();
        }
    }

    @Override
    public Long get_ID() {
        return id;
    }

    @Override
    public Boolean isDeleted() {
        return fl;
    }

    @Override
    public void makeDeleted() {
        fl = true;
    }

}
