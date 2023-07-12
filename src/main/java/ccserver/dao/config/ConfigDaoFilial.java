package ccserver.dao.config;

import ccserver.dao.FilialDAO;
import ccserver.entity.Filial;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ConfigDaoFilial extends ConfigDao<Filial> {

    @Autowired
    public ConfigDaoFilial(FilialDAO eDAO) {
        eDAO.setClass(Filial.class);
        super.setDAO(eDAO);
    }

}