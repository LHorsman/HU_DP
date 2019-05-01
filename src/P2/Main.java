package P2;

import java.util.ArrayList;

public class Main {
    private static String randomString(int count) {
        String ALPHA_NUMERIC_STRING = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        StringBuilder builder = new StringBuilder();
        while (count-- != 0) {
            int character = (int)(Math.random()*ALPHA_NUMERIC_STRING.length());
            builder.append(ALPHA_NUMERIC_STRING.charAt(character));
        }

        return builder.toString();
    }

    public static void main(String[] args) {
        ReizigerOracleDaolmpl reizigerDao = new ReizigerOracleDaolmpl();

        //maak nieuwe reizigers aan/nieuwe kaarten.
        ArrayList<Reiziger> reizigers = new ArrayList<Reiziger>();
        for (int i = 0; i < 5; i += 1) {
            int reizigernummer = (int)(Math.random() * 10000 + 1);
            String generatedString = randomString(5);
            Reiziger r = new Reiziger(generatedString, generatedString, generatedString, reizigernummer, java.sql.Date.valueOf("1990-12-23"));

            int amountofcards = (int)(Math.random() * 3 + 1);
            for(int j = 0; j < amountofcards; j += 1) {
                int kaarnummer = (int)(Math.random() * 100000000 + 1);
                OVChipkaart ov = new OVChipkaart(kaarnummer, java.sql.Date.valueOf("2020-12-23"), 1, 25.00, r);
                r.addKaart(ov);
            }

            reizigers.add(r);
        }

        //maak de nieuwe reizigers aan.
        reizigers.forEach(r -> reizigerDao.safe(r));
        //sla de nieuwe reizigers tijdelijk op.
        ArrayList<Reiziger> tijdelijkeLijst = reizigerDao.findAll();

        reizigers.forEach(r -> {
            //update de naam van de reizigers om duidelijk te maken dat het werkt.
            r.setVoornaam("UPDATED");

            r.getKaarten().forEach(k -> {
                //update de saldo van de kaarten.
                k.setSaldo(10.00);
            });

            reizigerDao.update(r);
        });


        ArrayList<Reiziger> tijdelijkeUpdatedLijst = reizigerDao.findAll();

        //laat de geupdate reizigers zien.
        tijdelijkeUpdatedLijst.forEach(r -> {
            System.out.println(r);
            r.getKaarten().forEach(k -> {
                System.out.println(k);
            });
        });

        //dit kan uitgecomment worden als je de items in de database wilt zien.
        reizigers.forEach(r -> {
            reizigerDao.delete(r);
        });



    }
}