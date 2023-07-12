package ccserver.service;

import ccserver.dto.ObmenDTO;
import ccserver.entity.Obmen;
import org.springframework.stereotype.Service;

@Service
public class ServiceObmen extends EntityService<Obmen, ObmenDTO> {}