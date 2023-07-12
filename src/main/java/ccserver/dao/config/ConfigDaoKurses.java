package ccserver.dao.config;

import ccserver.dao.KursesDAO;
import ccserver.entity.Kurses;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;

@Component
public class ConfigDaoKurses extends ConfigDao<Kurses> {

    @Autowired
    public ConfigDaoKurses(KursesDAO eDAO) {
        eDAO.setClass(Kurses.class);
        super.setDAO(eDAO);
    }

}