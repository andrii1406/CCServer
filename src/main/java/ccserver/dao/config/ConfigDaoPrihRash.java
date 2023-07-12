package ccserver.dao.config;

import ccserver.dao.PrihRashDAO;
import ccserver.entity.PrihRash;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;

@Component
public class ConfigDaoPrihRash extends ConfigDao<PrihRash> {

    @Autowired
    public ConfigDaoPrihRash(PrihRashDAO eDAO) {
        eDAO.setClass(PrihRash.class);
        super.setDAO(eDAO);
    }

}