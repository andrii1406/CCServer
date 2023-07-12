package ccserver.controller.config;

import ccserver.dto.KursesPublicDTO;
import ccserver.entity.KursesPublic;
import ccserver.service.ServiceKursesPublic;
import ccserver.service.config.ServiceConfigKursesPublic;
import jakarta.persistence.RollbackException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import java.util.List;

@Controller
public class ControllerKursesPublic extends EntityController<KursesPublic, KursesPublicDTO> {

    private final ServiceKursesPublic eService;


    @Autowired
    public ControllerKursesPublic(ServiceConfigKursesPublic serviceConfig) {
        setService(serviceConfig.getService());
        this.eService = (ServiceKursesPublic) serviceConfig.getService();
    }

    public List<KursesPublicDTO> readKursesPublicPriemsAndProdsByTv(Long tv) throws NullPointerException, ClassCastException, SecurityException, IllegalStateException, RollbackException {
        return eService.readKursesPublicPriemsAndProdsByTv(tv);
    }

}
