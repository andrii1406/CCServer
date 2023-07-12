package ccserver.controller.config;

import ccserver.dto.jwt.RoleDTO;
import ccserver.entity.jwt.Role;
import ccserver.service.config.ServiceConfigRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class ControllerRole extends EntityController<Role, RoleDTO> {

    @Autowired
    public ControllerRole(ServiceConfigRole serviceConfig) {
        setService(serviceConfig.getService());
    }

}
