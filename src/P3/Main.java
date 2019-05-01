package P3;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ReizigerOracleDaolmpl reizigerDao = new ReizigerOracleDaolmpl();

        reizigerDao.findAll().forEach(r -> {
            System.out.println(r.getVoornaam() + " " + r.getTussenvoegsel() + " " + r.getAchternaam());
            r.getKaarten().forEach(k -> {
                System.out.println(k);
                k.getProducten().forEach(p -> {
                    System.out.println(p);
                });
            });
        });

    }
}