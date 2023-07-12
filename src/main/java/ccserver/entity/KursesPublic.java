package ccserver.entity;

import jakarta.persistence.*;
import java.util.Date;

@Entity
public class KursesPublic implements IEntity<KursesPublic> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Kurses k;

    private Date u;


    public KursesPublic() {}

    public KursesPublic(Long id, Kurses k, Date u) {
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

    public Kurses getK() {
        return k;
    }

    public void setK(Kurses k) {
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
        return "KursesPublic{" +
                "id=" + id +
                ", k=" + k +
                ", u=" + u +
                '}';
    }

    @Override
    public void copyFieldsFrom(KursesPublic entity) {
        if (entity != null) {
            if(entity.getK() != null) this.k = entity.getK();
            if(entity.getU() != null) this.u = entity.getU();
        }
    }

    @Override
    public Long get_ID() {
        return id;
    }

    @Override
    public Boolean isDeleted() {
        return false;
    }

    @Override
    public void makeDeleted() {}

}
