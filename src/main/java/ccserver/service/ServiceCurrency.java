package ccserver.service;

import ccserver.dto.CurrencyDTO;
import ccserver.entity.Currency;
import org.springframework.stereotype.Service;

@Service
public class ServiceCurrency extends EntityService<Currency, CurrencyDTO> {}