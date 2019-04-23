package P1;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ReizigerOracleDaolmpl reizigerDao = new ReizigerOracleDaolmpl();

        ArrayList<Reiziger> lijst = reizigerDao.findByGBdatum("1997-03-27 16:17:33");

        Reiziger luuk = lijst.get(0);

        System.out.println(luuk.getReizigerNummer());

        luuk.setVoornaam("Luuk");

        reizigerDao.update(luuk);
    }
}