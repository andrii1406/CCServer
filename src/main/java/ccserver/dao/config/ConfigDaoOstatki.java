package ccserver.dao.config;

import ccserver.dao.OstatkiDAO;
import ccserver.entity.Ostatki;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;

@Component
public class ConfigDaoOstatki extends ConfigDao<Ostatki> {

    @Autowired
    public ConfigDaoOstatki(OstatkiDAO eDAO) {
        eDAO.setClass(Ostatki.class);
        super.setDAO(eDAO);
    }

}