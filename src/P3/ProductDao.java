package P3;

import java.util.ArrayList;

public interface ProductDao {
    public ArrayList<Product> findByKaart(OVChipkaart kaart);
}
