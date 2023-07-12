package ccserver.service.config;

import ccserver.dao.config.ConfigDaoUser;
import ccserver.dto.jwt.UserDTO;
import ccserver.entity.jwt.User;
import ccserver.mapper.jwt.MapperUser;
import ccserver.service.ServiceUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ServiceConfigUser extends ServiceConfig<User, UserDTO> {

    @Autowired
    public ServiceConfigUser(ServiceUser eService,
                             ConfigDaoUser configDao,
                             MapperUser eMapper
    ) {
        eService.setDAO(configDao.getDAO());
        eService.setMapper(eMapper);
        setService(eService);
    }

}