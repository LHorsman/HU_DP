package P2;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ReizigerOracleDaolmpl reizigerDao = new ReizigerOracleDaolmpl();

        //haal alle reizigers op.
        ArrayList<Reiziger> lijst = reizigerDao.findAll();


        //lijst met alle reizigers
        lijst.forEach(r -> {
            //print de naam om duidelijk te maken over wie het gaat.
            System.out.println(r.getVoornaam() + " " + r.getAchternaam());

            //print elke toString van de kaart uit.
            r.getKaarten().forEach(k -> {
                System.out.println(k);
            });
        });

    }
}