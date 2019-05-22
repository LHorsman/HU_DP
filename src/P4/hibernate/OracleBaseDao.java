package P4.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import java.sql.SQLException;
import java.text.ParseException;

public class OracleBaseDao {
    private static SessionFactory factory;

    public Session getConnection() throws SQLException, ParseException {
        try {
            factory = new Configuration().configure().buildSessionFactory();
        } catch (Throwable ex) {
            System.err.println("Failed to create sessionFactory object." + ex);
            throw new ExceptionInInitializerError(ex);
        }

        return factory.openSession();
//      Transaction t = session.beginTransaction();

//        Reiziger reiziger = (Reiziger) session.load(Reiziger.class, 2);

//        System.out.println(reiziger.getKaarten());

//      session.save(log);
//      t.commit();
//      System.out.println("successfully saved");
//        factory.close();
//        session.close();
    }
}
