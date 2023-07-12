package ccserver.controller.config;

import ccserver.dto.PrihRashDTO;
import ccserver.entity.PrihRash;
import ccserver.service.ServiceKursesPublic;
import ccserver.service.ServicePrihRash;
import ccserver.service.config.ServiceConfigPrihRash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import java.util.Date;
import java.util.List;

@Controller
public class ControllerPrihRash extends EntityController<PrihRash, PrihRashDTO> {

    private final ServicePrihRash eService;


    @Autowired
    public ControllerPrihRash(ServiceConfigPrihRash serviceConfig) {
        setService(serviceConfig.getService());
        this.eService = (ServicePrihRash) serviceConfig.getService();
    }

    public List<PrihRashDTO> readByPrAndNpAndDt(Long pr_id, Long npo, Date dtB, Date dtE) throws NullPointerException, ClassCastException {
        return eService.readByPrAndNpAndDt(pr_id, npo, dtB, dtE);
    }

}
