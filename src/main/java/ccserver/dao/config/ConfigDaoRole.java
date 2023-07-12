package ccserver.dao.config;

import ccserver.dao.RoleDAO;
import ccserver.entity.jwt.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ConfigDaoRole extends ConfigDao<Role> {

    @Autowired
    public ConfigDaoRole(RoleDAO eDAO) {
        eDAO.setClass(Role.class);
        super.setDAO(eDAO);
    }

}