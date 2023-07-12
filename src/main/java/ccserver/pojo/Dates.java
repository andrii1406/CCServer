package ccserver.pojo;

import java.util.Date;

public class Dates {

    private Date dtB;
    private Date dtE;


    public Dates() {}

    public Dates(Date dtB, Date dtE) {
        this.dtB = dtB;
        this.dtE = dtE;
    }

    public Date getDtB() {
        return dtB;
    }

    public void setDtB(Date dtB) {
        this.dtB = dtB;
    }

    public Date getDtE() {
        return dtE;
    }

    public void setDtE(Date dtE) {
        this.dtE = dtE;
    }

    @Override
    public String toString() {
        return "Dates{" +
                "dtB=" + dtB +
                ", dtE=" + dtE +
                '}';
    }
}
