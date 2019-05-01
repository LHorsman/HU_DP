package P3;

public class Product {
    private int productnummer;
    private String productNaam;
    private String beschrijving;
    private double prijs;
    private OVChipkaart ov;

    public Product(int productnummer, String productNaam, String beschrijving, double prijs, OVChipkaart k) {
        this.productnummer = productnummer;
        this.productNaam = productNaam;
        this.beschrijving = beschrijving;
        this.prijs = prijs;
        this.ov = k;
    }

    public int getProductnummer() {
        return productnummer;
    }

    public String getProductNaam() {
        return productNaam;
    }

    public String getBeschrijving() {
        return beschrijving;
    }

    public double getPrijs() {
        return prijs;
    }

    public void setProductnummer(int productnummer) {
        this.productnummer = productnummer;
    }

    public void setProductNaam(String productNaam) {
        this.productNaam = productNaam;
    }

    public void setBeschrijving(String beschrijving) {
        this.beschrijving = beschrijving;
    }

    public void setPrijs(double prijs) {
        this.prijs = prijs;
    }

    public String toString() {
        return this.productnummer + ": " + this.productNaam + ": " + this.beschrijving;
    }
}
