package ccserver.dao;

import ccserver.entity.Currency;
import ccserver.util.SessionUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CurrencyDAO extends EntityDAO<Currency> {

    @Autowired
    public CurrencyDAO(SessionUtil sessionUtil) {
        super.setSessionUtil(sessionUtil);
    }

}