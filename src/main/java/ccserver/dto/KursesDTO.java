package ccserver.dto;

import java.util.Date;

public class KursesDTO {

    private Long id;

    private Long np;

    private Long tv;

    private ObmenDTO pp;

    private CurrencyDTO vl;

    private Double krs;

    private Date dt;

    private Boolean fl;


    public KursesDTO() {}

    public KursesDTO(Long id) {
        this.id = id;
    }

    public KursesDTO(Long id, Long np, Long tv, ObmenDTO pp, CurrencyDTO vl, Double krs, Date dt, Boolean fl) {
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

    public ObmenDTO getPp() {
        return pp;
    }

    public void setPp(ObmenDTO pp) {
        this.pp = pp;
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

    @Override
    public String toString() {
        return "KursesDTO{" +
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

}
