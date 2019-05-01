package P3;

import java.util.ArrayList;

public interface ReizigerDao {
    public ArrayList<Reiziger> findByGBdatum(String GBdatum);
}
