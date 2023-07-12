package ccserver.service.config;

import ccserver.dao.config.ConfigDaoOstatki;
import ccserver.dto.OstatkiDTO;
import ccserver.entity.Ostatki;
import ccserver.mapper.MapperOstatki;
import ccserver.service.ServiceOstatki;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ServiceConfigOstatki extends ServiceConfig<Ostatki, OstatkiDTO> {

    @Autowired
    public ServiceConfigOstatki(ServiceOstatki eService,
                              ConfigDaoOstatki configDao,
                              MapperOstatki eMapper
    ) {
        eService.setDAO(configDao.getDAO());
        eService.setMapper(eMapper);
        setService(eService);
    }

}