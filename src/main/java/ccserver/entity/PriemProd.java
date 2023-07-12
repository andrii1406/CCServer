package ccserver.entity;

import java.util.Date;
import jakarta.persistence.*;

@Entity
public class PriemProd implements IEntity<PriemProd> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long np;

    @ManyToOne
    private Obmen pp;

    private Double sm;

    @ManyToOne
    private Currency vl;

    private Double krs;

    private Date dt;

    private Boolean fl;

    private Date dts;


    public PriemProd() {}

    public PriemProd(Long id, Long np, Obmen pp, Double sm, Currency vl,
                     Double krs, Date dt, Boolean fl, Date dts) {
        this.id = id;
        this.np = np;
        this.pp = pp;
        this.sm = sm;
        this.vl = vl;
        this.krs = krs;
        this.dt = dt;
        this.fl = fl;
        this.dts = dts == null ? new Date() : dts;
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

    public Obmen getPp() {
        return pp;
    }

    public void setPp(Obmen pp) {
        this.pp = pp;
    }

    public Double getSm() {
        return sm;
    }

    public void setSm(Double sm) {
        this.sm = sm;
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

    public Date getDts() {
        return dts;
    }

    public void setDts(Date dts) {
        this.dts = dts;
    }

    @Override
    public String toString() {
        return "PriemProd{" +
                "id=" + id +
                ", np=" + np +
                ", pp=" + pp +
                ", sm=" + sm +
                ", vl=" + vl +
                ", krs=" + krs +
                ", dt=" + dt +
                ", fl=" + fl +
                ", dts=" + dts +
                '}';
    }

    @Override
    public void copyFieldsFrom(PriemProd entity) {
        if (entity != null) {
            if(entity.getNp() != null) this.np = entity.getNp();
            if(entity.getPp() != null) this.pp = entity.getPp();
            if(entity.getSm() != null) this.sm = entity.getSm();
            if(entity.getVl() != null) this.vl = entity.getVl();
            if(entity.getKrs() != null) this.krs = entity.getKrs();
            if(entity.getDt() != null) this.dt = entity.getDt();
            if(entity.getDts() != null) this.dts = entity.getDts();
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
