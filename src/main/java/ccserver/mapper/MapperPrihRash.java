package ccserver.mapper;

import ccserver.dto.PrihRashDTO;
import ccserver.entity.PrihRash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MapperPrihRash implements EntityMapper<PrihRash, PrihRashDTO> {

    private MapperOperation mapperOperation;

    private MapperCurrency mapperCurrency;

    private MapperKstat mapperKstat;


    public MapperPrihRash() {}

    @Autowired
    public MapperPrihRash(MapperOperation mapperOperation, MapperCurrency mapperCurrency, MapperKstat mapperKstat) {
        this.mapperOperation = mapperOperation;
        this.mapperCurrency = mapperCurrency;
        this.mapperKstat = mapperKstat;
    }

    public PrihRashDTO mapToDTO(PrihRash e) {
        return new PrihRashDTO(
                e.getId(),
                e.getNpo(),
                mapperOperation.mapToDTO(e.getPr()),
                e.getSm(),
                mapperCurrency.mapToDTO(e.getVl()),
                e.getNpk(),
                e.getDt(),
                mapperKstat.mapToDTO(e.getKstat()),
                e.getPrim(),
                e.getFl(),
                e.getDts()
        );
    }

    public PrihRash mapToEntity(PrihRashDTO dto) {
        return new PrihRash(
                dto.getId(),
                dto.getNpo(),
                mapperOperation.mapToEntity(dto.getPr()),
                dto.getSm(),
                mapperCurrency.mapToEntity(dto.getVl()),
                dto.getNpk(),
                dto.getDt(),
                mapperKstat.mapToEntity(dto.getKstat()),
                dto.getPrim(),
                dto.getFl(),
                dto.getDts()
        );
    }

}