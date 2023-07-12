package ccserver.dto.jwt;

import ccserver.entity.jwt.ERole;

public class RoleDTO {

    private Long id;

    private ERole name;

    public RoleDTO() {}

    public RoleDTO(Long id, ERole name) {
        this.id = id;
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

    public void setRole(ERole name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "RoleDTO {" +
                "id = " + id +
                ", name = '" + name + '\'' +
                '}';
    }

}
