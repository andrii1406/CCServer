package ccserver.service;

import ccserver.dto.OperationDTO;
import ccserver.entity.Operation;
import org.springframework.stereotype.Service;

@Service
public class ServiceOperation extends EntityService<Operation, OperationDTO> {}