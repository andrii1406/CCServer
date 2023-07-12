package ccserver.controller.config;

import ccserver.dto.jwt.UserDTO;
import ccserver.entity.jwt.User;
import ccserver.service.config.ServiceConfigUser;
import ccserver.service.ServiceUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class ControllerUser extends EntityController<User, UserDTO> {

    private final ServiceUser eService;

    @Autowired
    public ControllerUser(ServiceConfigUser serviceConfig) {
        setService(serviceConfig.getService());
        this.eService = (ServiceUser) serviceConfig.getService();
    }

    public Boolean existsByUsername(String username) {
        return eService.existsByUsername(username);
    }

    public Boolean existsByEmail(String email) {
        return eService.existsByEmail(email);
    }

}
