package ccserver.dto;

import java.util.Date;

public class OstatkiDTO {

    private Long id;

    private Long np;

    private CurrencyDTO vl;

    private Double ost;

    private Date dt;

    private Boolean fl;


    public OstatkiDTO() {}

    public OstatkiDTO(Long id) {
        this.id = id;
    }

    public OstatkiDTO(Long id, Long np, CurrencyDTO vl, Double ost, Date dt, Boolean fl) {
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

    public CurrencyDTO getVl() {
        return vl;
    }

    public void setVl(CurrencyDTO vl) {
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
        return "OstatkiDTO{" +
                "id=" + id +
                ", np=" + np +
                ", vl=" + vl +
                ", ost=" + ost +
                ", dt=" + dt +
                ", fl=" + fl +
                '}';
    }

}
