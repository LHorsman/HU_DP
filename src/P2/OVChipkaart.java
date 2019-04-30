package P2;

import java.sql.Date;

public class OVChipkaart {
    private int kaartnummer;
    private Date geldigtot;
    private int klasse;
    private float saldo;
    private int reizigerId;

    public OVChipkaart(int kaarnummer, Date geldigtot, int klasse, float saldo, int reizigerId) {
        this.kaartnummer = kaarnummer;
        this.geldigtot = geldigtot;
        this.klasse = klasse;
        this.saldo = saldo;
        this.reizigerId = reizigerId;
    }

    public String toString() {
        String s = "";
        s+= kaartnummer + ": " + saldo + " van: " + reizigerId;
        return s;
    }
}
