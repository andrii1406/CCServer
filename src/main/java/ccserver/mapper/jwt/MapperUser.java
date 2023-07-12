package ccserver.mapper.jwt;

import ccserver.dao.RoleDAO;
import ccserver.dto.jwt.UserDTO;
import ccserver.entity.jwt.ERole;
import ccserver.entity.jwt.Role;
import ccserver.entity.jwt.User;
import ccserver.mapper.EntityMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class MapperUser implements EntityMapper<User, UserDTO> {

    private RoleDAO roleDAO;


    public MapperUser() {}

    @Autowired
    public MapperUser(RoleDAO roleDAO) {
        this.roleDAO = roleDAO;
    }

    public UserDTO mapToDTO(User e) {
        if (e == null)
            return new UserDTO();

        List<GrantedAuthority> authorities = e.getRoles().stream()
                .map(role -> new SimpleGrantedAuthority(role.getName().toString()))
                .collect(Collectors.toList());

        return new UserDTO(
                e.getId(),
                e.getUsername(),
                e.getEmail(),
                e.getPassword(),
                authorities
        );
    }

    public User mapToEntity(UserDTO dto) {
        Set<ERole> eRoles = dto.getAuthorities().stream()
                .map(grantedAuthority -> ERole.fromString(grantedAuthority.getAuthority()))
                .collect(Collectors.toSet());

        Set<Role> roles = eRoles.stream()
                .map(eRole -> roleDAO.findByName(eRole))
                .collect(Collectors.toSet());

        return new User(
                dto.getId(),
                dto.getUsername(),
                dto.getEmail(),
                dto.getPassword(),
                roles
        );
    }

}