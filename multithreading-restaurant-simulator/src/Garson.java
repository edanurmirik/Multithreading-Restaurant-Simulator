import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

public class Garson extends Thread {
    public String name;
    private static BlockingQueue<Musteri> siparisKuyrugu = new LinkedBlockingQueue<>();
    public Musteri ilgilendigiMusteri;
    public boolean calisiyor;

    public Garson(String name) {
        this.name = name;
        ilgilendigiMusteri = null;
        calisiyor = false;
    }

    public static void musteriEkle(Musteri musteri) {
        try {
            siparisKuyrugu.put(musteri);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    private void siparisAlveIlet() throws InterruptedException {

        Musteri musteri = siparisKuyrugu.take();
        musteri.setSiparisAlindiMi(true);
        ilgilendigiMusteri = musteri;
        calisiyor = true;
        System.out.println(this.name + ", " + musteri.name + " adlı müşterinin siparişini aldı.");
        System.out.println("---------------------------------------------------------");
        TimeUnit.SECONDS.sleep(2);
        ilgilendigiMusteri = null;
        calisiyor = false;
        Asci.yeniSiparisAl(musteri);
    }

    @Override
    public void run() {
        while (true) {
            try {
                siparisAlveIlet();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
