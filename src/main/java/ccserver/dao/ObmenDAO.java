package ccserver.dao;

import ccserver.entity.Obmen;
import ccserver.util.SessionUtil;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;

@Component
public class ObmenDAO extends EntityDAO<Obmen> {

    @Autowired
    public ObmenDAO(SessionUtil sessionUtil) {
        super.setSessionUtil(sessionUtil);
    }

}