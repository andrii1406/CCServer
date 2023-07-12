package ccserver.dao;

import ccserver.entity.Filial;
import ccserver.util.SessionUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FilialDAO extends EntityDAO<Filial> {

    @Autowired
    public FilialDAO(SessionUtil sessionUtil) {
        super.setSessionUtil(sessionUtil);
    }

}