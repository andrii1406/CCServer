package ccserver.dao;

import ccserver.entity.Kstat;
import ccserver.util.SessionUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class KstatDAO extends EntityDAO<Kstat> {

    @Autowired
    public KstatDAO(SessionUtil sessionUtil) {
        super.setSessionUtil(sessionUtil);
    }

}