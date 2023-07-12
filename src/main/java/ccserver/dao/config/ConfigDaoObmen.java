package ccserver.dao.config;

import ccserver.dao.ObmenDAO;
import ccserver.entity.Obmen;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;

@Component
public class ConfigDaoObmen extends ConfigDao<Obmen> {

    @Autowired
    public ConfigDaoObmen(ObmenDAO eDAO) {
        eDAO.setClass(Obmen.class);
        super.setDAO(eDAO);
    }

}