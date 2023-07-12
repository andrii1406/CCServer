package ccserver.dao.config;

import ccserver.dao.OperationDAO;
import ccserver.entity.Operation;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;

@Component
public class ConfigDaoOperation extends ConfigDao<Operation> {

    @Autowired
    public ConfigDaoOperation(OperationDAO eDAO) {
        eDAO.setClass(Operation.class);
        super.setDAO(eDAO);
    }

}