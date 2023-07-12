package ccserver.util;

import org.hibernate.Session;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;

@Component
public class SessionUtil {

    private final HibernateUtil hibernateUtil;

    @Autowired
    public SessionUtil(HibernateUtil hibernateUtil) {
        this.hibernateUtil = hibernateUtil;
    }

    public Session openSession() {
        return hibernateUtil.getSessionFactory().openSession();
    }

}