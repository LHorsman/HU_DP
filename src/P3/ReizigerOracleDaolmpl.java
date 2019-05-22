package P3;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ReizigerOracleDaolmpl extends OracleBaseDao implements Dao<Reiziger>, ReizigerDao {
    private OVChipkaartOracleDaoImpl ovChip;

    public ReizigerOracleDaolmpl() {
        this.ovChip = new OVChipkaartOracleDaoImpl();
    }

    @Override
    public ArrayList<Reiziger> findAll() {
        ArrayList<Reiziger> reizigers = new ArrayList<Reiziger>();

        try {
            ResultSet result = this.getConnection().createStatement().executeQuery("SELECT * FROM REIZIGER ");

            while(result.next()) {
                Reiziger reiziger = new Reiziger(result.getString("voorletters"), result.getString("tussenvoegsel"), result.getString("achternaam"), result.getInt("reizigerID"), result.getDate("gebortedatum"));
                reiziger.setKaarten(this.ovChip.findByReiziger(reiziger));
                reizigers.add(reiziger);
            }

            return reizigers;
        } catch(SQLException e) {
            System.out.println(e.getMessage());
        }

        return reizigers;
    }

    @Override
    public ArrayList<Reiziger> findByGBdatum(String GBdatum) {
        ArrayList<Reiziger> reizigers = new ArrayList<Reiziger>();

        try {
            PreparedStatement prepStatement = this.getConnection().prepareStatement(" SELECT * FROM REIZIGER WHERE GEBORTEDATUM = TO_DATE(?,'YYYY-MM-DD HH24:MI:SS')");

            prepStatement.setString(1, GBdatum);

            ResultSet result = prepStatement.executeQuery();

            while(result.next()) {
                Reiziger reiziger = new Reiziger(result.getString("voorletters"), result.getString("tussenvoegsel"), result.getString("achternaam"), result.getInt("reizigerID"), result.getDate("gebortedatum"));
                reiziger.setKaarten(this.ovChip.findByReiziger(reiziger));
                reizigers.add(reiziger);
            }

        } catch(SQLException e) {
            System.out.println(e.getMessage());
        }

        return reizigers;
    }

    @Override
    public Reiziger safe(Reiziger reiziger) {
        try {
            PreparedStatement prepStatement = this.getConnection().prepareStatement("INSERT INTO REIZIGER (REIZIGERID, VOORLETTERS, TUSSENVOEGSEL, ACHTERNAAM, GEBORTEDATUM) VALUES (?, ?, ?, ?, ?)");
            prepStatement.setInt(1, reiziger.getReizigerNummer());
            prepStatement.setString(2, reiziger.getVoornaam());
            prepStatement.setString(3, reiziger.getTussenvoegsel());
            prepStatement.setString(4, reiziger.getAchternaam());
            prepStatement.setDate(5, reiziger.getGBdatum());

            ResultSet result = prepStatement.executeQuery();

            return reiziger;
        } catch(SQLException e) {
            System.out.println(e.getMessage());
        }

        return reiziger;
    }


    @Override
    public Reiziger update(Reiziger reiziger) {
        try {
            PreparedStatement prepStatement = this.getConnection().prepareStatement("UPDATE REIZIGER SET VOORLETTERS = ?, TUSSENVOEGSEL = ?, ACHTERNAAM = ?, GEBORTEDATUM = ? WHERE REIZIGERID = ?");
            prepStatement.setString(1, reiziger.getVoornaam());
            prepStatement.setString(2, reiziger.getTussenvoegsel());
            prepStatement.setString(3, reiziger.getAchternaam());
            prepStatement.setDate(4, reiziger.getGBdatum());
            prepStatement.setInt(5, reiziger.getReizigerNummer());

            ResultSet result = prepStatement.executeQuery();

        } catch(SQLException e) {
            System.out.println(e.getMessage());
        }

        return reiziger;
    }


    @Override
    public Reiziger delete(Reiziger reiziger) {

        try {

            reiziger.getKaarten().forEach(k -> ovChip.delete(k));

            PreparedStatement prepStatement = this.getConnection().prepareStatement("DELETE FROM REIZIGER WHERE REIZIGERID = ?");
            prepStatement.setInt(1, reiziger.getReizigerNummer());

            ResultSet result = prepStatement.executeQuery();
            return reiziger;
        } catch(SQLException e) {
            System.out.println(e.getMessage());
        }

        return reiziger;
    }

    public Reiziger findByReizgerNummer(int nummer) {
        Reiziger reiziger = null;

        try {
            PreparedStatement prepStatement = this.getConnection().prepareStatement(" SELECT * FROM REIZIGER WHERE REIZIGERID = ?");

            prepStatement.setInt(1, nummer);

            ResultSet result = prepStatement.executeQuery();

            while(result.next()) {
                reiziger = new Reiziger(result.getString("voorletters"), result.getString("tussenvoegsel"), result.getString("achternaam"), result.getInt("reizigerID"), result.getDate("gebortedatum"));
                reiziger.setKaarten(this.ovChip.findByReiziger(reiziger));
            }

            return reiziger;
        } catch(SQLException e) {
            System.out.println(e.getMessage());
        }

        return reiziger;
    }


    @Override
    public void closeConnection() {

    }
}
