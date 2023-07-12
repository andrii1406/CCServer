package ccserver.service;

import ccserver.dao.UserDAO;
import ccserver.dao.config.ConfigDaoUser;
import ccserver.dto.jwt.UserDTO;
import ccserver.entity.jwt.User;
import ccserver.mapper.jwt.MapperUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import jakarta.transaction.Transactional;

@Service
public class ServiceUser extends EntityService<User, UserDTO> implements UserDetailsService {

    private final UserDAO eDAO;

    private final MapperUser eMapper;


    @Autowired
    public ServiceUser(ConfigDaoUser configDao, MapperUser eMapper) {
        this.eDAO = (UserDAO) configDao.getDAO();
        this.eMapper = eMapper;
    }

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return eMapper.mapToDTO(eDAO.findByUsername(username));
    }

    @Transactional
    public Boolean existsByUsername(String username) {
        return eDAO.existsByUsername(username);
    }

    @Transactional
    public Boolean existsByEmail(String email) {
        return eDAO.existsByEmail(email);
    }

}
