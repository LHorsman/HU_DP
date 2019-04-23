package P1;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ReizigerOracleDaolmpl extends OracleBaseDao implements ReizigerDao {

    @Override
    public ArrayList<Reiziger> findAll() {
        ArrayList<Reiziger> reizigers = new ArrayList<Reiziger>();

        try {
            ResultSet result = this.getConnection().createStatement().executeQuery("SELECT * FROM REIZIGER");


            while(result.next()) {
                Reiziger reiziger = new Reiziger(result.getString("voornaam"), result.getString("tussenvoegsel"), result.getString("achternaam"), result.getInt("reizigerID"), result.getDate("geboortedatum"));
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
            PreparedStatement prepStatement = this.getConnection().prepareStatement("SELECT * FROM REIZIGER WHERE GEBOORTEDATUM = TO_DATE(?,'YYYY-MM-DD HH24:MI:SS')");

            prepStatement.setString(1, GBdatum);

            ResultSet result = prepStatement.executeQuery();

            while(result.next()) {
                Reiziger reiziger = new Reiziger(result.getString("voornaam"), result.getString("tussenvoegsel"), result.getString("achternaam"), result.getInt("reizigerID"), result.getDate("geboortedatum"));
                reizigers.add(reiziger);
            }

        } catch(SQLException e) {
            System.out.println(e.getMessage());
        }

        return reizigers;
    }

    @Override
    public Reiziger safe(Reiziger reiziger) {
        Reiziger nieuwereiziger = null;

        try {
            PreparedStatement prepStatement = this.getConnection().prepareStatement("INSERT INTO REIZIGER (VOORNAAM, TUSSENVOEGSEL, ACHTERNAAM, GEBOORTEDATUM) VALUES (?, ?, ?, ?)");
            prepStatement.setString(1, reiziger.getVoornaam());
            prepStatement.setString(2, reiziger.getTussenvoegsel());
            prepStatement.setString(3, reiziger.getAchternaam());
            prepStatement.setDate(4, reiziger.getGBdatum());


            ResultSet result = prepStatement.executeQuery();

            System.out.println(result);

        } catch(SQLException e) {
            System.out.println(e.getMessage());
        }

        return nieuwereiziger;
    }

    @Override
    public Reiziger update(Reiziger reiziger) {

        try {
            PreparedStatement prepStatement = this.getConnection().prepareStatement("UPDATE REIZIGER SET VOORNAAM = ?, TUSSENVOEGSEL = ?, ACHTERNAAM = ?, GEBOORTEDATUM = ? WHERE REIZIGERID = ?");
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
        return null;
    }

    @Override
    public void closeConnection() {

    }
}
