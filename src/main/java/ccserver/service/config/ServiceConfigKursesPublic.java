package ccserver.service.config;

import ccserver.dao.config.ConfigDaoKursesPublic;
import ccserver.dto.KursesPublicDTO;
import ccserver.entity.KursesPublic;
import ccserver.mapper.MapperKursesPublic;
import ccserver.service.ServiceKursesPublic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ServiceConfigKursesPublic extends ServiceConfig<KursesPublic, KursesPublicDTO> {

    @Autowired
    public ServiceConfigKursesPublic(ServiceKursesPublic eService,
                              ConfigDaoKursesPublic configDao,
                              MapperKursesPublic eMapper
    ) {
        eService.setDAO(configDao.getDAO());
        eService.setMapper(eMapper);
        setService(eService);
    }

}