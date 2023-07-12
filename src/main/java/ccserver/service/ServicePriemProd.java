package ccserver.service;

import ccserver.dao.PriemProdDAO;
import ccserver.dao.config.ConfigDaoPriemProd;
import ccserver.dto.PriemProdDTO;
import ccserver.entity.PriemProd;
import ccserver.mapper.MapperPriemProd;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ServicePriemProd extends EntityService<PriemProd, PriemProdDTO> {

    private final PriemProdDAO eDAO;

    private final MapperPriemProd eMapper;


    @Autowired
    public ServicePriemProd(ConfigDaoPriemProd configDao, MapperPriemProd eMapper) {
        this.eDAO = (PriemProdDAO) configDao.getDAO();
        this.eMapper = eMapper;
    }

    public List<PriemProdDTO> readByPpAndNpAndDt(Long pp_id, Long np, Date dtB, Date dtE) throws NullPointerException, ClassCastException {
        return eDAO
                .readByPpAndNpAndDt(pp_id, np, dtB, dtE)
                .stream()
                .map(eMapper::mapToDTO)
                .collect(Collectors.toList());
    }

}