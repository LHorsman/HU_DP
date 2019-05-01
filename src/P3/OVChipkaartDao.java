package P3;

import java.util.ArrayList;

public interface OVChipkaartDao {
    public ArrayList<OVChipkaart> findAll();
    public ArrayList<OVChipkaart> findByReizigerid(int id);
}
