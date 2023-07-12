package ccserver.controller.config;

import ccserver.dto.KursesDTO;
import ccserver.entity.Kurses;
import ccserver.service.ServiceKurses;
import ccserver.service.config.ServiceConfigKurses;
import jakarta.persistence.RollbackException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import java.util.Date;

@Controller
public class ControllerKurses extends EntityController<Kurses, KursesDTO> {

    private final ServiceKurses eService;


    @Autowired
    public ControllerKurses(ServiceConfigKurses serviceConfig) {
        setService(serviceConfig.getService());
        this.eService = (ServiceKurses) serviceConfig.getService();
    }

    public void deleteKursesByNpAndDt(Long np, Date dtB, Date dtE) throws NullPointerException, ClassCastException, SecurityException, IllegalStateException, RollbackException {
        eService.deleteKursesByNpAndDt(np, dtB, dtE);
    }

}
