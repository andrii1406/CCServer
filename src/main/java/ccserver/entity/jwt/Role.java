package ccserver.entity.jwt;

import ccserver.entity.IEntity;

import jakarta.persistence.*;

@Entity
@Table(name = "roles")
public class Role implements IEntity<Role> {

    @Id
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(length = 20)
    private ERole name;

    public Role() {}

    public Role(Long id, ERole name) {
        this.id = id;
        this.name = name;
    }

    public Role(ERole name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ERole getName() {
        return name;
    }

    public void setName(ERole name) {
        this.name = name;
    }

    @Override
    public void copyFieldsFrom(Role entity) {
        if (entity != null) {
            this.id = entity.getId();
            this.name = entity.getName();
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

    @Override
    public String toString() {
        return "Role {" +
                "id = " + id +
                ", name = " + name +
                '}';
    }

}
