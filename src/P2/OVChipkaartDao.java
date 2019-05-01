package P2;

import java.util.ArrayList;

public interface OVChipkaartDao {
    public ArrayList<OVChipkaart> findAll();
    public ArrayList<OVChipkaart> findByReiziger(Reiziger r);
    public OVChipkaart safe(OVChipkaart ov);
    public OVChipkaart update(OVChipkaart ov);
    public OVChipkaart delete(OVChipkaart ov);
}
