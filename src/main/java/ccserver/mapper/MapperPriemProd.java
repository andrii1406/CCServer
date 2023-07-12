package ccserver.mapper;

import ccserver.dto.PriemProdDTO;
import ccserver.entity.PriemProd;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MapperPriemProd implements EntityMapper<PriemProd, PriemProdDTO> {

    private final MapperObmen mapperObmen;

    private final MapperCurrency mapperCurrency;


    @Autowired
    public MapperPriemProd(MapperObmen mapperObmen, MapperCurrency mapperCurrency) {
        this.mapperObmen = mapperObmen;
        this.mapperCurrency = mapperCurrency;
    }

    public PriemProdDTO mapToDTO(PriemProd e) {
        return new PriemProdDTO(
                e.getId(),
                e.getNp(),
                mapperObmen.mapToDTO(e.getPp()),
                e.getSm(),
                mapperCurrency.mapToDTO(e.getVl()),
                e.getKrs(),
                e.getDt(),
                e.getFl(),
                e.getDts()
        );
    }

    public PriemProd mapToEntity(PriemProdDTO dto) {
        return new PriemProd(
                dto.getId(),
                dto.getNp(),
                mapperObmen.mapToEntity(dto.getPp()),
                dto.getSm(),
                mapperCurrency.mapToEntity(dto.getVl()),
                dto.getKrs(),
                dto.getDt(),
                dto.getFl(),
                dto.getDts()
        );
    }

}