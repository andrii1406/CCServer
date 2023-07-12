package ccserver.mapper;

import ccserver.dto.OperationDTO;
import ccserver.entity.Obmen;
import ccserver.entity.Operation;
import org.springframework.stereotype.Component;

@Component
public class MapperOperation implements EntityMapper<Operation, OperationDTO> {


    public MapperOperation() {}

    public OperationDTO mapToDTO(Operation e) {
        return new OperationDTO(
                e.getId(),
                e.getOpr()
        );
    }

    public Operation mapToEntity(OperationDTO dto) {
        if (dto == null)
            return new Operation();

        return new Operation(
                dto.getId(),
                dto.getOpr()
        );
    }

}