package ccserver.controller.config;

import ccserver.dto.PriemProdDTO;
import ccserver.entity.PriemProd;
import ccserver.service.ServicePriemProd;
import ccserver.service.config.ServiceConfigPriemProd;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import java.util.Date;
import java.util.List;

@Controller
public class ControllerPriemProd extends EntityController<PriemProd, PriemProdDTO> {

    private final ServicePriemProd eService;


    @Autowired
    public ControllerPriemProd(ServiceConfigPriemProd serviceConfig) {
        setService(serviceConfig.getService());
        this.eService = (ServicePriemProd) serviceConfig.getService();
    }

    public List<PriemProdDTO> readByPpAndNpAndDt(Long pp_id, Long np, Date dtB, Date dtE) throws NullPointerException, ClassCastException {
        return eService.readByPpAndNpAndDt(pp_id, np, dtB, dtE);
    }

}
