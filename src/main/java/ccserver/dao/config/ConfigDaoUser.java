package ccserver.dao.config;

import ccserver.dao.UserDAO;
import ccserver.entity.jwt.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ConfigDaoUser extends ConfigDao<User> {

    @Autowired
    public ConfigDaoUser(UserDAO eDAO) {
        eDAO.setClass(User.class);
        super.setDAO(eDAO);
    }

}