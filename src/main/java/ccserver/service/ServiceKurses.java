package ccserver.service;

import ccserver.dao.KursesDAO;
import ccserver.dao.config.ConfigDaoKurses;
import ccserver.dto.KursesDTO;
import ccserver.entity.Kurses;
import jakarta.persistence.RollbackException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Date;

@Service
public class ServiceKurses extends EntityService<Kurses, KursesDTO> {

    private final KursesDAO eDAO;


    @Autowired
    public ServiceKurses(ConfigDaoKurses configDao) {
        this.eDAO = (KursesDAO) configDao.getDAO();
    }

    public void deleteKursesByNpAndDt(Long np, Date dtB, Date dtE) throws NullPointerException, ClassCastException, SecurityException, IllegalStateException, RollbackException {
        eDAO.deleteKursesByNpAndDt(np, dtB, dtE);
    }

}