package P4.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.sql.SQLException;
import java.text.ParseException;

public class Main {
  private static SessionFactory factory;

  public static void main(String[] args) throws SQLException, ParseException {
      ReizigerOracleDaoImpl rei = new ReizigerOracleDaoImpl();

      rei.findAll().forEach(r -> {
          r.getKaarten().forEach(k -> {
              System.out.println(k);
          });
      });

//      try {
//        factory = new Configuration().configure().buildSessionFactory();
//      } catch (Throwable ex) {
//        System.err.println("Failed to create sessionFactory object." + ex);
//        throw new ExceptionInInitializerError(ex);
//      }
//      Session session = factory.openSession();
////      Transaction t = session.beginTransaction();
//
//      Reiziger reiziger = (Reiziger) session.load(Reiziger.class, 2);
//
//      System.out.println(reiziger.getKaarten());
//
////      session.save(log);
////      t.commit();
////      System.out.println("successfully saved");
//      factory.close();
//      session.close();
  }
}
