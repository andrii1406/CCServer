package ccserver.service.config;

import ccserver.dao.config.ConfigDaoObmen;
import ccserver.dto.ObmenDTO;
import ccserver.entity.Obmen;
import ccserver.mapper.MapperObmen;
import ccserver.service.ServiceObmen;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ServiceConfigObmen extends ServiceConfig<Obmen, ObmenDTO> {

    @Autowired
    public ServiceConfigObmen(ServiceObmen eService,
                              ConfigDaoObmen configDao,
                              MapperObmen eMapper
    ) {
        eService.setDAO(configDao.getDAO());
        eService.setMapper(eMapper);
        setService(eService);
    }

}