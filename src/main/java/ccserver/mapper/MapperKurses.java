package ccserver.mapper;

import ccserver.dto.KursesDTO;
import ccserver.entity.Kurses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MapperKurses implements EntityMapper<Kurses, KursesDTO> {

    private final MapperObmen mapperObmen;

    private final MapperCurrency mapperCurrency;


    @Autowired
    public MapperKurses(MapperObmen mapperObmen, MapperCurrency mapperCurrency) {
        this.mapperObmen = mapperObmen;
        this.mapperCurrency = mapperCurrency;
    }

    public KursesDTO mapToDTO(Kurses e) {
        return new KursesDTO(
                e.getId(),
                e.getNp(),
                e.getTv(),
                mapperObmen.mapToDTO(e.getPp()),
                mapperCurrency.mapToDTO(e.getVl()),
                e.getKrs(),
                e.getDt(),
                e.getFl()
        );
    }

    public Kurses mapToEntity(KursesDTO dto) {
        return new Kurses(
                dto.getId(),
                dto.getNp(),
                dto.getTv(),
                mapperObmen.mapToEntity(dto.getPp()),
                mapperCurrency.mapToEntity(dto.getVl()),
                dto.getKrs(),
                dto.getDt(),
                dto.getFl()
        );
    }

}