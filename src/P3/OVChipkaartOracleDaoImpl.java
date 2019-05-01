package P3;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class OVChipkaartOracleDaoImpl extends OracleBaseDao implements Dao<OVChipkaart>, OVChipkaartDao {
    private ProductOracleDaoImpl product;

    public OVChipkaartOracleDaoImpl() {
        this.product = new ProductOracleDaoImpl();
    }

    @Override
    public ArrayList<OVChipkaart> findAll() {
//        ArrayList<OVChipkaart> ovs = new ArrayList<OVChipkaart>();
//
//        try {
//            ResultSet result = this.getConnection().createStatement().executeQuery("SELECT * FROM OV_CHIPKAART");
//
//            while(result.next()) {
//                OVChipkaart ov = new OVChipkaart(result.getInt("kaartnummer"), result.getDate("geldigtot"), result.getInt("klasse"), result.getFloat("saldo"), result.getInt("reizigerid"));
//                ovs.add(ov);
//            }
//
//        } catch(SQLException e) {
//            System.out.println(e.getMessage());
//        }
//
//        return null;
        return null;
    }

    @Override
    public ArrayList<OVChipkaart> findByReiziger(Reiziger r) {
        ArrayList<OVChipkaart> ovs = new ArrayList<OVChipkaart>();

        try {
            PreparedStatement prepStatement = this.getConnection().prepareStatement(" SELECT * FROM OV_CHIPKAART WHERE reizigerid = ?");
            prepStatement.setInt(1, r.getReizigerNummer());
            ResultSet result = prepStatement.executeQuery();

            while(result.next()) {
                OVChipkaart ov = new OVChipkaart(result.getInt("kaartnummer"), result.getDate("geldigtot"), result.getInt("klasse"), result.getFloat("saldo"), r);
                ov.setProducten(product.findByKaart(ov));
                ovs.add(ov);
            }

            return ovs;
        } catch(SQLException e) {
            System.out.println(e.getMessage());
        }

        return ovs;
    }

    @Override
    public OVChipkaart safe(OVChipkaart ov) {
        try {
            PreparedStatement prepStatement = this.getConnection().prepareStatement("INSERT INTO OV_CHIPKAART VALUES (?, ?, ?, ?, ?)");
            prepStatement.setInt(1, ov.getKaartnummer());
            prepStatement.setDate(2, ov.getGeldigtot());
            prepStatement.setInt(3, ov.getKlasse());
            prepStatement.setDouble(4, ov.getSaldo());
            prepStatement.setInt(5, ov.getReiziger().getReizigerNummer());

            ResultSet result = prepStatement.executeQuery();

            return ov;
        } catch(SQLException e) {
            System.out.println(e.getMessage());
        }

        return ov;
    }

    @Override
    public OVChipkaart update(OVChipkaart ov) {
        try {
            PreparedStatement prepStatement = this.getConnection().prepareStatement("UPDATE OV_CHIPKAART SET GELDIGTOT = ?, klasse = ?, saldo = ?, reizigerid = ? WHERE kaartnummer = ?");
            prepStatement.setDate(1, ov.getGeldigtot());
            prepStatement.setInt(2, ov.getKlasse());
            prepStatement.setDouble(3, ov.getSaldo());
            prepStatement.setInt(4, ov.getReiziger().getReizigerNummer());
            prepStatement.setInt(5, ov.getKaartnummer());
            ResultSet result = prepStatement.executeQuery();
            return ov;
        } catch(SQLException e) {
            System.out.println(e.getMessage());
        }

        return ov;
    }

    @Override
    public OVChipkaart delete(OVChipkaart ov) {
        try {
            PreparedStatement prepStatement = this.getConnection().prepareStatement("DELETE FROM OV_CHIPKAART WHERE kaartnummer = ?");
            prepStatement.setInt(1, ov.getKaartnummer());
            ResultSet result = prepStatement.executeQuery();
            return ov;
        } catch(SQLException e) {
            System.out.println(e.getMessage());
        }

        return ov;
    }

    @Override
    public void closeConnection() {

    }
}
