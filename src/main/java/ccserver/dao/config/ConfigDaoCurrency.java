package ccserver.dao.config;

import ccserver.dao.CurrencyDAO;
import ccserver.entity.Currency;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ConfigDaoCurrency extends ConfigDao<Currency> {

    @Autowired
    public ConfigDaoCurrency(CurrencyDAO eDAO) {
        eDAO.setClass(Currency.class);
        super.setDAO(eDAO);
    }

}