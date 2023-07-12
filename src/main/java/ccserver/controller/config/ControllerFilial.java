package ccserver.controller.config;

import ccserver.dto.FilialDTO;
import ccserver.entity.Filial;
import ccserver.service.config.ServiceConfigFilial;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class ControllerFilial extends EntityController<Filial, FilialDTO> {

    @Autowired
    public ControllerFilial(ServiceConfigFilial serviceConfig) {
        setService(serviceConfig.getService());
    }

}
