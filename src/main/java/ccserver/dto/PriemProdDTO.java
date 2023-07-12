package ccserver.dto;

import java.util.Date;

public class PriemProdDTO {

    private Long id;

    private Long np;

    private ObmenDTO pp;

    private Double sm;

    private CurrencyDTO vl;

    private Double krs;

    private Date dt;

    private Boolean fl;

    private Date dts;


    public PriemProdDTO() {}

    public PriemProdDTO(Long id) {
        this.id = id;
    }

    public PriemProdDTO(Long id, Long np, ObmenDTO pp, Double sm, CurrencyDTO vl,
                        Double krs, Date dt, Boolean fl, Date dts) {
        this.id = id;
        this.np = np;
        this.pp = pp;
        this.sm = sm;
        this.vl = vl;
        this.krs = krs;
        this.dt = dt;
        this.fl = fl;
        this.dts = dts;
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

    public ObmenDTO getPp() {
        return pp;
    }

    public void setPp(ObmenDTO pp) {
        this.pp = pp;
    }

    public Double getSm() {
        return sm;
    }

    public void setSm(Double sm) {
        this.sm = sm;
    }

    public CurrencyDTO getVl() {
        return vl;
    }

    public void setVl(CurrencyDTO vl) {
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
        return "PriemProdDTO{" +
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

}
