package ccserver.dao.config;

import ccserver.dao.KursesPublicDAO;
import ccserver.entity.KursesPublic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ConfigDaoKursesPublic extends ConfigDao<KursesPublic> {

    @Autowired
    public ConfigDaoKursesPublic(KursesPublicDAO eDAO) {
        eDAO.setClass(KursesPublic.class);
        super.setDAO(eDAO);
    }

}