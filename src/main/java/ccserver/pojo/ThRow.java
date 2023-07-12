package ccserver.pojo;

public class ThRow {

    private String p0;

    private String p1;

    private String pvl;

    public ThRow(String p0, String p1, String pvl) {
        this.p0 = p0;
        this.p1 = p1;
        this.pvl = pvl;
    }

    public String getP0() {
        return p0;
    }

    public void setP0(String p0) {
        this.p0 = p0;
    }

    public String getP1() {
        return p1;
    }

    public void setP1(String p1) {
        this.p1 = p1;
    }

    public String getPvl() {
        return pvl;
    }

    public void setPvl(String pvl) {
        this.pvl = pvl;
    }

    @Override
    public String toString() {
        return "ThRow{" +
                "p0='" + p0 + '\'' +
                ", p1='" + p1 + '\'' +
                ", pvl='" + pvl + '\'' +
                '}';
    }

}
