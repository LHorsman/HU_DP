package P2;

import java.sql.Date;
import java.util.ArrayList;

public class Reiziger {
    private int reizigerNummer;
    private String voornaam;
    private String tussenvoegsel;
    private String achternaam;
    private Date gbdatum;
    private ArrayList<OVChipkaart> kaarten;

    public Reiziger(String voornaam, String tussenvoegsel, String achternaam, int reizigerNummer, Date gbdatum) {
        this.voornaam = voornaam;
        this.tussenvoegsel = tussenvoegsel;
        this.achternaam = achternaam;
        this.reizigerNummer = reizigerNummer;
        this.gbdatum = gbdatum;
    }

    public String getVoornaam() {
        return voornaam;
    }

    public String getAchternaam() {
        return achternaam;
    }

    public String getTussenvoegsel() {
        return tussenvoegsel;
    }

    public int getReizigerNummer() {
        return reizigerNummer;
    }

    public void setVoornaam(String naam) {
        this.voornaam = naam;
    }

    public void setAchternaam(String naam) {
        this.achternaam = naam;
    }

    public void setTussenvoegsel(String naam) {
        this.tussenvoegsel = naam;
    }

    public void setReizigerNummer(int nummer) {
        this.reizigerNummer = nummer;
    }

    public Date getGBdatum() {
        return gbdatum;
    }

    public void setKaarten(ArrayList<OVChipkaart> kaarten) {
        this.kaarten = kaarten;
    }

    public ArrayList<OVChipkaart> getKaarten() {
        return this.kaarten;
    }

    public void setGbdatum(Date gbdatum) {
        this.gbdatum = gbdatum;
    }


    public String toString() {
        return this.voornaam;
    }
}
