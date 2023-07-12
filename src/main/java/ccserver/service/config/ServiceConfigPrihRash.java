package ccserver.service.config;

import ccserver.dao.config.ConfigDaoPrihRash;
import ccserver.dto.PrihRashDTO;
import ccserver.entity.PrihRash;
import ccserver.mapper.MapperPrihRash;
import ccserver.service.ServicePrihRash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ServiceConfigPrihRash extends ServiceConfig<PrihRash, PrihRashDTO> {

    @Autowired
    public ServiceConfigPrihRash(ServicePrihRash eService,
                                 ConfigDaoPrihRash configDao,
                                 MapperPrihRash eMapper
    ) {
        eService.setDAO(configDao.getDAO());
        eService.setMapper(eMapper);
        setService(eService);
    }

}
