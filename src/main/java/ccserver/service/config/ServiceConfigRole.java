package ccserver.service.config;

import ccserver.dao.config.ConfigDaoRole;
import ccserver.dto.jwt.RoleDTO;
import ccserver.entity.jwt.Role;
import ccserver.mapper.jwt.MapperRole;
import ccserver.service.ServiceRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ServiceConfigRole extends ServiceConfig<Role, RoleDTO> {

    @Autowired
    public ServiceConfigRole(ServiceRole eService,
                             ConfigDaoRole configDao,
                             MapperRole eMapper
    ) {
        eService.setDAO(configDao.getDAO());
        eService.setMapper(eMapper);
        setService(eService);
    }

}