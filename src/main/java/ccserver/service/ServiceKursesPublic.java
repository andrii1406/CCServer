package ccserver.service;

import ccserver.dao.KursesPublicDAO;
import ccserver.dao.config.ConfigDaoKursesPublic;
import ccserver.dto.KursesPublicDTO;
import ccserver.entity.KursesPublic;
import ccserver.mapper.MapperKursesPublic;
import jakarta.persistence.RollbackException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ServiceKursesPublic extends EntityService<KursesPublic, KursesPublicDTO> {

    private final KursesPublicDAO eDAO;

    private final MapperKursesPublic eMapper;


    @Autowired
    public ServiceKursesPublic(ConfigDaoKursesPublic configDao, MapperKursesPublic eMapper) {
        this.eDAO = (KursesPublicDAO) configDao.getDAO();
        this.eMapper = eMapper;
    }

    public List<KursesPublicDTO> readKursesPublicPriemsAndProdsByTv(Long tv) throws NullPointerException, ClassCastException, SecurityException, IllegalStateException, RollbackException {
        return eDAO
                .readKursesPublicPriemsAndProdsByTv(tv)
                .stream()
                .map(eMapper::mapToDTO)
                .collect(Collectors.toList());
    }

}