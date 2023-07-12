package ccserver.mapper;

import ccserver.dto.OstatkiDTO;
import ccserver.entity.Ostatki;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MapperOstatki implements EntityMapper<Ostatki, OstatkiDTO> {

    private final MapperCurrency mapperCurrency;


    @Autowired
    public MapperOstatki(MapperCurrency mapperCurrency) {
        this.mapperCurrency = mapperCurrency;
    }

    public OstatkiDTO mapToDTO(Ostatki e) {
        return new OstatkiDTO(
                e.getId(),
                e.getNp(),
                mapperCurrency.mapToDTO(e.getVl()),
                e.getOst(),
                e.getDt(),
                e.getFl()
        );
    }

    public Ostatki mapToEntity(OstatkiDTO dto) {
        return new Ostatki(
                dto.getId(),
                dto.getNp(),
                mapperCurrency.mapToEntity(dto.getVl()),
                dto.getOst(),
                dto.getDt(),
                dto.getFl()
        );
    }

}