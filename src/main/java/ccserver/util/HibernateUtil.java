package ccserver.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

@Component
public class HibernateUtil {

    private SessionFactory sessionFactory;

    private ConfigurationUtil configurationUtil;


    public HibernateUtil() {}

    @Autowired
    public HibernateUtil(ConfigurationUtil configurationUtil) {
        this.configurationUtil = configurationUtil;
        this.sessionFactory = buildSessionFactory();
    }

    private SessionFactory buildSessionFactory() {
        try {
            Configuration configuration = configurationUtil.getConfiguration();

            ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                    .applySettings(configuration.getProperties()).build();

            SessionFactory sf = configuration.buildSessionFactory(serviceRegistry);

            System.out.println("Фабрика сессий успешно создана!");

            return sf;
        } catch (Exception e) {
            System.out.println("Проблема при создании фабрики сессий!");
            e.printStackTrace();
        }

        return null;
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

}