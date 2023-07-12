package ccserver.mapper;

import ccserver.dto.FilialDTO;
import ccserver.entity.Currency;
import ccserver.entity.Filial;
import org.springframework.stereotype.Component;

@Component
public class MapperFilial implements EntityMapper<Filial, FilialDTO> {


    public MapperFilial() {}

    public FilialDTO mapToDTO(Filial e) {
        return new FilialDTO(
                e.getId(),
                e.getTv(),
                e.getCn()
        );
    }

    public Filial mapToEntity(FilialDTO dto) {
        if (dto == null)
            return new Filial();

        return new Filial(
                dto.getId(),
                dto.getTv(),
                dto.getCn()
        );
    }

}