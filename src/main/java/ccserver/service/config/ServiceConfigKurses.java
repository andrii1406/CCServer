package ccserver.service.config;

import ccserver.dao.config.ConfigDaoKurses;
import ccserver.dto.KursesDTO;
import ccserver.entity.Kurses;
import ccserver.mapper.MapperKurses;
import ccserver.service.ServiceKurses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ServiceConfigKurses extends ServiceConfig<Kurses, KursesDTO> {

    @Autowired
    public ServiceConfigKurses(ServiceKurses eService,
                                  ConfigDaoKurses configDao,
                                  MapperKurses eMapper
    ) {
        eService.setDAO(configDao.getDAO());
        eService.setMapper(eMapper);
        setService(eService);
    }

}