package ccserver.mapper.jwt;

import ccserver.dto.jwt.RoleDTO;
import ccserver.entity.jwt.Role;
import ccserver.mapper.EntityMapper;
import org.springframework.stereotype.Component;

@Component
public class MapperRole implements EntityMapper<Role, RoleDTO> {


    public MapperRole() {}

    public RoleDTO mapToDTO(Role e) {
        if (e == null)
            return new RoleDTO();

        return new RoleDTO(
                e.getId(),
                e.getName()
        );
    }

    public Role mapToEntity(RoleDTO dto) {
        return new Role(
                dto.getId(),
                dto.getName()
        );
    }

}