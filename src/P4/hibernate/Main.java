package P4.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.sql.Date;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;

public class Main {
  private static SessionFactory factory;

  public static void main(String[] args) throws SQLException, ParseException {
      ReizigerOracleDaoImpl rei = new ReizigerOracleDaoImpl();
//
//      Reiziger r = new Reiziger("luuk", "", "horsman", 102380, new Date(1999, 3, 23));
//
//      ArrayList<OVChipkaart> ovs = new ArrayList<OVChipkaart>();
//
//      ovs.add(new OVChipkaart(10293, new Date(2020, 1, 1), 1, 15.00, r));
//      ovs.add(new OVChipkaart(102234, new Date(2020, 1, 1), 1, 15.00, r));
//
//      r.setKaarten(ovs);
//
//      rei.update(r);




      rei.findAll().forEach(r -> {
          System.out.println(r.getVoornaam() + " " + r.getAchternaam());

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
