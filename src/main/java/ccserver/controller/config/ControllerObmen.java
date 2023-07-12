package ccserver.controller.config;

import ccserver.dto.ObmenDTO;
import ccserver.entity.Obmen;
import ccserver.service.config.ServiceConfigObmen;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class ControllerObmen extends EntityController<Obmen, ObmenDTO> {

    @Autowired
    public ControllerObmen(ServiceConfigObmen serviceConfig) {
        setService(serviceConfig.getService());
    }

}
