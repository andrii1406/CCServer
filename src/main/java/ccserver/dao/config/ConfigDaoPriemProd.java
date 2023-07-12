package ccserver.dao.config;

import ccserver.dao.PriemProdDAO;
import ccserver.entity.PriemProd;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;

@Component
public class ConfigDaoPriemProd extends ConfigDao<PriemProd> {

    @Autowired
    public ConfigDaoPriemProd(PriemProdDAO eDAO) {
        eDAO.setClass(PriemProd.class);
        super.setDAO(eDAO);
    }

}