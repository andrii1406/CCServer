package ccserver.dao;

import ccserver.entity.Ostatki;
import ccserver.util.SessionUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OstatkiDAO extends EntityDAO<Ostatki> {

    @Autowired
    public OstatkiDAO(SessionUtil sessionUtil) {
        super.setSessionUtil(sessionUtil);
    }

}