package ccserver.mapper;

import ccserver.dto.KursesPublicDTO;
import ccserver.entity.KursesPublic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MapperKursesPublic implements EntityMapper<KursesPublic, KursesPublicDTO> {

    private final MapperKurses mapperKurses;


    @Autowired
    public MapperKursesPublic(MapperKurses mapperKurses) {
        this.mapperKurses = mapperKurses;
    }

    public KursesPublicDTO mapToDTO(KursesPublic e) {
        return new KursesPublicDTO(
                e.getId(),
                mapperKurses.mapToDTO(e.getK()),
                e.getU()
        );
    }

    public KursesPublic mapToEntity(KursesPublicDTO dto) {
        return new KursesPublic(
                dto.getId(),
                mapperKurses.mapToEntity(dto.getK()),
                dto.getU()
        );
    }

}