package ccserver.service;

import ccserver.dto.jwt.RoleDTO;
import ccserver.entity.jwt.Role;
import org.springframework.stereotype.Service;

@Service
public class ServiceRole extends EntityService<Role, RoleDTO> {}