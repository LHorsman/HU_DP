package P3;

import java.util.ArrayList;

public interface OVChipkaartDao extends Dao<OVChipkaart> {
    public ArrayList<OVChipkaart> findByReiziger(Reiziger r);
}
