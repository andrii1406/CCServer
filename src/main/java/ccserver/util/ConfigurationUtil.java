package ccserver.util;

import ccserver.entity.*;
import java.util.Properties;
import ccserver.entity.jwt.Role;
import ccserver.entity.jwt.User;
import org.hibernate.cfg.Environment;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Component;

@Component
public class ConfigurationUtil {

    private final Configuration configuration = new Configuration();

    private final Properties properties = new Properties();


    public ConfigurationUtil() {
        putSQLiteProperties();
        //putMySQLProperties();

        configuration.setProperties(properties);

        configuration
                .addAnnotatedClass(Ostatki.class)
                .addAnnotatedClass(KursesPublic.class)
                .addAnnotatedClass(Kurses.class)
                .addAnnotatedClass(PriemProd.class)
                .addAnnotatedClass(Obmen.class)
                .addAnnotatedClass(PrihRash.class)
                .addAnnotatedClass(Operation.class)
                .addAnnotatedClass(Currency.class)
                .addAnnotatedClass(Kstat.class)
                .addAnnotatedClass(Filial.class)
                .addAnnotatedClass(User.class)
                .addAnnotatedClass(Role.class)
        ;
    }

    private void putSQLiteProperties() {
        properties.put(Environment.DRIVER, "org.sqlite.JDBC");
        properties.put(Environment.URL, "jdbc:sqlite:OP.sqlite");
        properties.put(Environment.USER, "");
        properties.put(Environment.PASS, "");
        //properties.put(Environment.DIALECT, "org.hibernate.dialect.SQLiteDialect");           //0.1.0         com.github.gwenn
        //properties.put(Environment.DIALECT, "org.sqlite.hibernate.dialect.SQLiteDialect");    //0.1.4         com.github.gwenn
        properties.put(Environment.DIALECT, "org.hibernate.community.dialect.SQLiteDialect");   //6.2.3.Final   hibernate-community-dialects
        properties.put(Environment.SHOW_SQL, "false");
        properties.put(Environment.FORMAT_SQL, "true");
        properties.put(Environment.HBM2DDL_AUTO, "create-drop");
    }

    private void putMySQLProperties() {
        properties.put(Environment.DRIVER, "com.mysql.cj.jdbc.Driver");
        properties.put(Environment.URL, "jdbc:mysql://localhost:3306/OP");
        properties.put(Environment.USER, "root");
        properties.put(Environment.PASS, "root");
        //properties.put(Environment.DIALECT, "org.hibernate.dialect.MySQL57Dialect");
        properties.put(Environment.DIALECT, "org.hibernate.dialect.MySQL8Dialect");
        properties.put(Environment.SHOW_SQL, "false");
        properties.put(Environment.FORMAT_SQL, "true");
        properties.put(Environment.HBM2DDL_AUTO, " create-drop");
    }

    public Configuration getConfiguration() {
        return configuration;
    }

}