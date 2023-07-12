package ccserver.mapper;

import ccserver.dto.KstatDTO;
import ccserver.entity.Kstat;
import org.springframework.stereotype.Component;

@Component
public class MapperKstat implements EntityMapper<Kstat, KstatDTO> {


    public MapperKstat() {}

    public KstatDTO mapToDTO(Kstat e) {
        return new KstatDTO(
                e.getId(),
                e.getStat()
        );
    }

    public Kstat mapToEntity(KstatDTO dto) {
        if (dto == null)
            return new Kstat();

        return new Kstat(
                dto.getId(),
                dto.getStat()
        );
    }

}