package ccserver.entity;

import java.util.Date;
import jakarta.persistence.*;

@Entity
public class PrihRash implements IEntity<PrihRash> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long npo;

    @ManyToOne
    private Operation pr;

    private Double sm;

    @ManyToOne
    private Currency vl;

    private Long npk;

    private Date dt;

    @ManyToOne
    private Kstat kstat;

    private String prim;

    private Boolean fl;

    private Date dts;


    public PrihRash() {}

    public PrihRash(Long id, Long npo, Operation pr, Double sm, Currency vl, Long npk,
                    Date dt, Kstat kstat, String prim, Boolean fl, Date dts) {
        this.id = id;
        this.npo = npo;
        this.pr = pr;
        this.sm = sm;
        this.vl = vl;
        this.npk = npk;
        this.dt = dt;
        this.kstat = kstat;
        this.prim = prim;
        this.fl = fl;
        this.dts = dts == null ? new Date() : dts;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getNpo() {
        return npo;
    }

    public void setNpo(Long npo) {
        this.npo = npo;
    }

    public Operation getPr() {
        return pr;
    }

    public void setPr(Operation pr) {
        this.pr = pr;
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

    public Long getNpk() {
        return npk;
    }

    public void setNpk(Long npk) {
        this.npk = npk;
    }

    public Date getDt() {
        return dt;
    }

    public void setDt(Date dt) {
        this.dt = dt;
    }

    public Kstat getKstat() {
        return kstat;
    }

    public void setKstat(Kstat kstat) {
        this.kstat = kstat;
    }

    public String getPrim() {
        return prim;
    }

    public void setPrim(String prim) {
        this.prim = prim;
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
        return "PrihRash{" +
                "id=" + id +
                ", npo=" + npo +
                ", pr=" + pr +
                ", sm=" + sm +
                ", vl=" + vl +
                ", npk=" + npk +
                ", dt=" + dt +
                ", kstat=" + kstat +
                ", prim='" + prim + '\'' +
                ", fl=" + fl +
                ", dts=" + dts +
                '}';
    }

    @Override
    public void copyFieldsFrom(PrihRash entity) {
        if (entity != null) {
            if(entity.getNpo() != null) this.npo = entity.getNpo();
            if(entity.getPr() != null) this.pr = entity.getPr();
            if(entity.getSm() != null) this.sm = entity.getSm();
            if(entity.getVl() != null) this.vl = entity.getVl();
            if(entity.getNpk() != null) this.npk = entity.getNpk();
            if(entity.getDt() != null) this.dt = entity.getDt();
            if(entity.getKstat() != null) this.kstat = entity.getKstat();
            if(entity.getPrim() != null) this.prim = entity.getPrim();
            if(entity.getFl() != null) this.fl = entity.getFl();
            if(entity.getDts() != null) this.dts = entity.getDts();
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
