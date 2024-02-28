import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class Kasiyer extends Thread {
    public String name;
    public Musteri odemeAldigiMusteri;
    private static BlockingQueue<Musteri> odemeBekleyenMusteriler;
    public boolean odemeAliyor;

    public Kasiyer(String name) {
        this.name = name;
        this.odemeBekleyenMusteriler = new LinkedBlockingQueue<>();
        this.odemeAldigiMusteri = null;
    }

    public static void yeniOdemeAl(Musteri musteri) {
        try {
            odemeBekleyenMusteriler.put(musteri);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();  // Restore interrupted status
            e.printStackTrace();
        }
    }

    private void odemeAl() throws InterruptedException {

        Musteri musteri = odemeBekleyenMusteriler.take();
        odemeAldigiMusteri = musteri;
        odemeAliyor = true;
        Thread.sleep(1000);
        odemeAliyor = false;
        musteri.setOdemeYapildiMi(true);
        System.out.println("Kasiyer, " + musteri.name + " adlı müşterinin ödeme işlemini gerçekleştirdi.");
        System.out.println("---------------------------------------------------------");
        odemeAldigiMusteri = null;
        Masa oturduguMasa = musteri.getOturduguMasa();
        if (oturduguMasa != null) {
            oturduguMasa.musteriKaldir();
        }
    }

    @Override
    public void run() {
        while (true) {
            try {
                odemeAl();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
