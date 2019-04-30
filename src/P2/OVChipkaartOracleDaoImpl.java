package P2;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class OVChipkaartOracleDaoImpl extends OracleBaseDao implements OVChipkaartDao {
    @Override
    public ArrayList<OVChipkaart> findAll() {
        ArrayList<OVChipkaart> ovs = new ArrayList<OVChipkaart>();

        try {
            ResultSet result = this.getConnection().createStatement().executeQuery("SELECT * FROM OV_CHIPKAART");

            while(result.next()) {
                OVChipkaart ov = new OVChipkaart(result.getInt("kaartnummer"), result.getDate("geldigtot"), result.getInt("klasse"), result.getFloat("saldo"), result.getInt("reizigerid"));
                ovs.add(ov);
            }

        } catch(SQLException e) {
            System.out.println(e.getMessage());
        }

        return null;
    }

    @Override
    public ArrayList<OVChipkaart> findByReizigerid(int id) {
        ArrayList<OVChipkaart> ovs = new ArrayList<OVChipkaart>();

        try {
            PreparedStatement prepStatement = this.getConnection().prepareStatement(" SELECT * FROM OV_CHIPKAART WHERE reizigerid = ?");
            prepStatement.setInt(1, id);
            ResultSet result = prepStatement.executeQuery();

            while(result.next()) {
                OVChipkaart ov = new OVChipkaart(result.getInt("kaartnummer"), result.getDate("geldigtot"), result.getInt("klasse"), result.getFloat("saldo"), result.getInt("reizigerid"));
                ovs.add(ov);
            }

            return ovs;
        } catch(SQLException e) {
            System.out.println(e.getMessage());
        }

        return ovs;
    }
}
