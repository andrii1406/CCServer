package ccserver.controller.config;

import ccserver.dto.OperationDTO;
import ccserver.entity.Operation;
import ccserver.service.config.ServiceConfigOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class ControllerOperation extends EntityController<Operation, OperationDTO> {

    @Autowired
    public ControllerOperation(ServiceConfigOperation serviceConfig) {
        setService(serviceConfig.getService());
    }

}
