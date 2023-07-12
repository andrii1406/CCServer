package ccserver.service.config;

import ccserver.dao.config.ConfigDaoOperation;
import ccserver.dto.OperationDTO;
import ccserver.entity.Operation;
import ccserver.mapper.MapperOperation;
import ccserver.service.ServiceOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ServiceConfigOperation extends ServiceConfig<Operation, OperationDTO> {

    @Autowired
    public ServiceConfigOperation(ServiceOperation eService,
                                  ConfigDaoOperation configDao,
                                  MapperOperation eMapper
    ) {
        eService.setDAO(configDao.getDAO());
        eService.setMapper(eMapper);
        setService(eService);
    }

}