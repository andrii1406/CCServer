package ccserver.service;

import ccserver.dao.PrihRashDAO;
import ccserver.dao.config.ConfigDaoPrihRash;
import ccserver.dto.PrihRashDTO;
import ccserver.entity.PrihRash;
import ccserver.mapper.MapperPrihRash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ServicePrihRash extends EntityService<PrihRash, PrihRashDTO> {

    private final PrihRashDAO eDAO;

    private final MapperPrihRash eMapper;


    @Autowired
    public ServicePrihRash(ConfigDaoPrihRash configDao, MapperPrihRash eMapper) {
        this.eDAO = (PrihRashDAO) configDao.getDAO();
        this.eMapper = eMapper;
    }

    public List<PrihRashDTO> readByPrAndNpAndDt(Long pr_id, Long npo, Date dtB, Date dtE) throws NullPointerException, ClassCastException {
        return eDAO
                .readByPrAndNpAndDt(pr_id, npo, dtB, dtE)
                .stream()
                .map(eMapper::mapToDTO)
                .collect(Collectors.toList());
    }

}