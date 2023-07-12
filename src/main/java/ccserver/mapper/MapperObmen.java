package ccserver.mapper;

import ccserver.dto.ObmenDTO;
import ccserver.entity.Obmen;
import org.springframework.stereotype.Component;

@Component
public class MapperObmen implements EntityMapper<Obmen, ObmenDTO> {


    public MapperObmen() {}

    public ObmenDTO mapToDTO(Obmen e) {

        return new ObmenDTO(
                e.getId(),
                e.getObm()
        );
    }

    public Obmen mapToEntity(ObmenDTO dto) {
        if (dto == null)
            return new Obmen();

        return new Obmen(
                dto.getId(),
                dto.getObm()
        );
    }

}