package ccserver.service;

import ccserver.dto.KstatDTO;
import ccserver.entity.Kstat;
import org.springframework.stereotype.Service;

@Service
public class ServiceKstat extends EntityService<Kstat, KstatDTO> {}