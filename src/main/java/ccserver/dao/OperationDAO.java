package ccserver.dao;

import ccserver.entity.Operation;
import ccserver.util.SessionUtil;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;

@Component
public class OperationDAO extends EntityDAO<Operation> {

    @Autowired
    public OperationDAO(SessionUtil sessionUtil) {
        super.setSessionUtil(sessionUtil);
    }

}