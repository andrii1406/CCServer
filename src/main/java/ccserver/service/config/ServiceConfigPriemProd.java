package ccserver.service.config;

import ccserver.dao.config.ConfigDaoPriemProd;
import ccserver.dto.PriemProdDTO;
import ccserver.entity.PriemProd;
import ccserver.mapper.MapperPriemProd;
import ccserver.service.ServicePriemProd;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ServiceConfigPriemProd extends ServiceConfig<PriemProd, PriemProdDTO> {

    @Autowired
    public ServiceConfigPriemProd(ServicePriemProd eService,
                                  ConfigDaoPriemProd configDao,
                                  MapperPriemProd eMapper
    ) {
        eService.setDAO(configDao.getDAO());
        eService.setMapper(eMapper);
        setService(eService);
    }

}
