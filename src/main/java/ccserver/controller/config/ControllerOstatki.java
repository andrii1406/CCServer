package ccserver.controller.config;

import ccserver.dto.OstatkiDTO;
import ccserver.entity.Ostatki;
import ccserver.service.config.ServiceConfigOstatki;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class ControllerOstatki extends EntityController<Ostatki, OstatkiDTO> {

    @Autowired
    public ControllerOstatki(ServiceConfigOstatki serviceConfig) {
        setService(serviceConfig.getService());
    }

}
