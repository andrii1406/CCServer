package ccserver.controller.config;

import ccserver.dto.CurrencyDTO;
import ccserver.entity.Currency;
import ccserver.service.config.ServiceConfigCurrency;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class ControllerCurrency extends EntityController<Currency, CurrencyDTO> {

    @Autowired
    public ControllerCurrency(ServiceConfigCurrency serviceConfig) {
        setService(serviceConfig.getService());
    }

}
