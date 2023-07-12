package ccserver.dao.config;

import ccserver.dao.KstatDAO;
import ccserver.entity.Kstat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ConfigDaoKstat extends ConfigDao<Kstat> {

    @Autowired
    public ConfigDaoKstat(KstatDAO eDAO) {
        eDAO.setClass(Kstat.class);
        super.setDAO(eDAO);
    }

}