package ccserver.controller.config;

import ccserver.dto.KstatDTO;
import ccserver.entity.Kstat;
import ccserver.service.config.ServiceConfigKstat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class ControllerKstat extends EntityController<Kstat, KstatDTO> {

    @Autowired
    public ControllerKstat(ServiceConfigKstat serviceConfig) {
        setService(serviceConfig.getService());
    }

}
