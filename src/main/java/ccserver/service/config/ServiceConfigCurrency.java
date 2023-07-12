package ccserver.service.config;

import ccserver.dao.config.ConfigDaoCurrency;
import ccserver.dto.CurrencyDTO;
import ccserver.entity.Currency;
import ccserver.mapper.MapperCurrency;
import ccserver.service.ServiceCurrency;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ServiceConfigCurrency extends ServiceConfig<Currency, CurrencyDTO> {

    @Autowired
    public ServiceConfigCurrency(ServiceCurrency eService,
                                 ConfigDaoCurrency configDao,
                                 MapperCurrency eMapper
    ) {
        eService.setDAO(configDao.getDAO());
        eService.setMapper(eMapper);
        setService(eService);
    }

}