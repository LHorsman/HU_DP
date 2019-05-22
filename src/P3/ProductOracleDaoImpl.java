package P3;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ProductOracleDaoImpl extends OracleBaseDao implements ProductDao {
    private OVChipkaartOracleDaoImpl ovchip;

    @Override
    public ArrayList<Product> findAll() {
        this.ovchip = new OVChipkaartOracleDaoImpl();
        ArrayList<Product> producten = new ArrayList<Product>();

        try {
            PreparedStatement prepStatement = this.getConnection().prepareStatement("SELECT * FROM PRODUCT");
            ResultSet result = prepStatement.executeQuery();

            while(result.next()) {
                Product p = new Product(result.getInt("productnummer"), result.getString("productnaam"), result.getString("beschrijving"), result.getDouble("prijs"));
                p.setOvChipkaartnummers(ovchip.getKaartnummersByProduct(p));
                producten.add(p);
            }

            return producten;
        } catch(SQLException e) {
            System.out.println(e.getMessage());
        }

        return producten;
    }

    @Override
    public Product safe(Product product) {
        return null;
    }

    @Override
    public Product update(Product product) {
        return null;
    }

    @Override
    public Product delete(Product product) {
        return null;
    }

    @Override
    public void closeConnection() {

    }

    @Override
    public ArrayList<Product> findByKaart(OVChipkaart kaart) {
        ArrayList<Product> producten = new ArrayList<Product>();
        this.ovchip = new OVChipkaartOracleDaoImpl();

        try {
            PreparedStatement prepStatement = this.getConnection().prepareStatement("SELECT P.* FROM OV_CHIPKAART_PRODUCT OCP INNER JOIN PRODUCT P on OCP.PRODUCTNUMMER = P.PRODUCTNUMMER WHERE ocp.kaartnummer = ?");
            prepStatement.setInt(1, kaart.getKaartnummer());
            ResultSet result = prepStatement.executeQuery();

            while(result.next()) {
                Product p = new Product(result.getInt("productnummer"), result.getString("productnaam"), result.getString("beschrijving"), result.getDouble("prijs"));
                p.setOvChipkaartnummers(ovchip.getKaartnummersByProduct(p));
                producten.add(p);
            }

            return producten;
        } catch(SQLException e) {
            System.out.println(e.getMessage());
        }

        return producten;
    }
}
