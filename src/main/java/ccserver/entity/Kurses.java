package ccserver.entity;

import jakarta.persistence.*;
import java.util.Date;

@Entity
public class Kurses implements IEntity<Kurses> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long np;

    private Long tv;

    @ManyToOne
    private Obmen pp;

    @ManyToOne
    private Currency vl;

    private Double krs;

    private Date dt;

    private Boolean fl;


    public Kurses() {}

    public Kurses(Long id, Long np, Long tv, Obmen pp, Currency vl, Double krs, Date dt, Boolean fl) {
        this.id = id;
        this.np = np;
        this.tv = tv;
        this.pp = pp;
        this.vl = vl;
        this.krs = krs;
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

    public Long getTv() {
        return tv;
    }

    public void setTv(Long tv) {
        this.tv = tv;
    }

    public Obmen getPp() {
        return pp;
    }

    public void setPp(Obmen pp) {
        this.pp = pp;
    }

    public Currency getVl() {
        return vl;
    }

    public void setVl(Currency vl) {
        this.vl = vl;
    }

    public Double getKrs() {
        return krs;
    }

    public void setKrs(Double krs) {
        this.krs = krs;
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
        return "Kurses{" +
                "id=" + id +
                ", np=" + np +
                ", tv=" + tv +
                ", pp=" + pp +
                ", vl=" + vl +
                ", krs=" + krs +
                ", dt=" + dt +
                ", fl=" + fl +
                '}';
    }

    @Override
    public void copyFieldsFrom(Kurses entity) {
        if (entity != null) {
            if(entity.getNp() != null) this.np = entity.getNp();
            if(entity.getTv() != null) this.tv = entity.getTv();
            if(entity.getPp() != null) this.pp = entity.getPp();
            if(entity.getVl() != null) this.vl = entity.getVl();
            if(entity.getKrs() != null) this.krs = entity.getKrs();
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
    public void makeDeleted() {fl = true;}

}
