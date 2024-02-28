public class YemekYe extends Thread {

    private Masa masa;

    YemekYe(Masa masa){
        this.masa = masa;
    }

    public static void yemekYe(Masa masa) throws InterruptedException {
        if (!masa.isEmpty() && masa.oturanMusteri.isYemegiHazirMi() && !masa.oturanMusteri.isYemekYiyorMu()) {
            masa.oturanMusteri.setYemekYiyorMu(true);
            System.out.println(masa.oturanMusteri.name + " adlı müşteri, yemeğini yiyor.");
            Thread.sleep(3000);
            masa.oturanMusteri.setYemegiBittiMi(true);
            System.out.println(masa.oturanMusteri.name + " adlı müşteri, yemeğini yedi.");
            System.out.println("---------------------------------------------------------");
            Kasiyer.yeniOdemeAl(masa.oturanMusteri);
        }
    }

    @Override
    public void run() {
        while (true) {
            for (Masa masa : Restaurant.masalar) {
                try {
                    yemekYe(masa);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
