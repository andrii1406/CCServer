package ccserver.service.config;

import ccserver.dao.config.ConfigDaoKstat;
import ccserver.dto.KstatDTO;
import ccserver.entity.Kstat;
import ccserver.mapper.MapperKstat;
import ccserver.service.ServiceKstat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ServiceConfigKstat extends ServiceConfig<Kstat, KstatDTO> {

    @Autowired
    public ServiceConfigKstat(ServiceKstat eService,
                              ConfigDaoKstat configDao,
                              MapperKstat eMapper
    ) {
        eService.setDAO(configDao.getDAO());
        eService.setMapper(eMapper);
        setService(eService);
    }

}