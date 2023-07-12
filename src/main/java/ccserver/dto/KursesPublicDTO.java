package ccserver.dto;

import java.util.Date;

public class KursesPublicDTO {

    private Long id;

    private KursesDTO k;

    private Date u;


    public KursesPublicDTO() {}

    public KursesPublicDTO(Long id) {
        this.id = id;
    }

    public KursesPublicDTO(Long id, KursesDTO k, Date u) {
        this.id = id;
        this.k = k;
        this.u = u;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public KursesDTO getK() {
        return k;
    }

    public void setK(KursesDTO k) {
        this.k = k;
    }

    public Date getU() {
        return u;
    }

    public void setU(Date u) {
        this.u = u;
    }

    @Override
    public String toString() {
        return "KursesPublicDTO{" +
                "id=" + id +
                ", k=" + k +
                ", u=" + u +
                '}';
    }

}
