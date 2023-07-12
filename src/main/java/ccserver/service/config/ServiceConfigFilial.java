package ccserver.service.config;

import ccserver.dao.config.ConfigDaoFilial;
import ccserver.dto.FilialDTO;
import ccserver.entity.Filial;
import ccserver.mapper.MapperFilial;
import ccserver.service.ServiceFilial;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ServiceConfigFilial extends ServiceConfig<Filial, FilialDTO> {

    @Autowired
    public ServiceConfigFilial(ServiceFilial eService,
                               ConfigDaoFilial configDao,
                               MapperFilial eMapper
    ) {
        eService.setDAO(configDao.getDAO());
        eService.setMapper(eMapper);
        setService(eService);
    }

}