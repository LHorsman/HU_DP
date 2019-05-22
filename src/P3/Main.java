package P3;

public class Main {
    public static void main(String[] args) {
        ReizigerOracleDaolmpl reizigerDao = new ReizigerOracleDaolmpl();

        OVChipkaartOracleDaoImpl ov = new OVChipkaartOracleDaoImpl();

//        System.out.println();

        ov.findAll().forEach(vo -> {
            System.out.println(vo);
            System.out.println(vo.getReiziger().getVoornaam() + " " + vo.getReiziger().getAchternaam());

            vo.getProducten().forEach(p -> {
                System.out.println(p);
            });
        });

//        ProductOracleDaoImpl podi = new ProductOracleDaoImpl();
//
//        System.out.println(podi.findAll());


//        reizigerDao.findAll().forEach(r -> {
//            System.out.println(r.getVoornaam() + " " + r.getTussenvoegsel() + " " + r.getAchternaam());
//            r.getKaarten().forEach(k -> {
//                k.getReiziger();
//                System.out.println(k);
//                k.getProducten().forEach(p -> {
//                    System.out.println(p);
//                });
//            });
//        });
    }
}