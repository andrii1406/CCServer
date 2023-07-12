package ccserver.dto;

import java.util.Date;

public class PrihRashDTO {

    private Long id;

    private Long npo;

    private OperationDTO pr;

    private Double sm;

    private CurrencyDTO vl;

    private Long npk;

    private Date dt;

    private KstatDTO kstat;

    private String prim;

    private Boolean fl;

    private Date dts;


    public PrihRashDTO() {}

    public PrihRashDTO(Long id) {
        this.id = id;
    }

    public PrihRashDTO(Long id, Long npo, OperationDTO pr, Double sm, CurrencyDTO vl, Long npk,
                       Date dt, KstatDTO kstat, String prim, Boolean fl, Date dts) {
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
        this.dts = dts;
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

    public OperationDTO getPr() {
        return pr;
    }

    public void setPr(OperationDTO pr) {
        this.pr = pr;
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

    public KstatDTO getKstat() {
        return kstat;
    }

    public void setKstat(KstatDTO kstat) {
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
        return "PrihRashDTO{" +
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

}
