package P3;

import java.util.ArrayList;

public interface ProductDao extends Dao<Product> {
    public ArrayList<Product> findByKaart(OVChipkaart kaart);
}
