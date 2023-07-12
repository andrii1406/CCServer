package ccserver.mapper;

import ccserver.dto.CurrencyDTO;
import ccserver.entity.Currency;
import ccserver.entity.Obmen;
import org.springframework.stereotype.Component;

@Component
public class MapperCurrency implements EntityMapper<Currency, CurrencyDTO> {


    public MapperCurrency() {}

    public CurrencyDTO mapToDTO(Currency e) {

        return new CurrencyDTO(
                e.getId(),
                e.getVl()
        );
    }

    public Currency mapToEntity(CurrencyDTO dto) {
        if (dto == null)
            return new Currency();

        return new Currency(
                dto.getId(),
                dto.getVl()
        );
    }

}