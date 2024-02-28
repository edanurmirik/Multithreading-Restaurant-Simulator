import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Random;

public class MusteriOlustur extends Thread {
    private static Random random = new Random();
    private int sayac;

    public MusteriOlustur() {
        this.sayac = 0;
    }

    private synchronized void olustur() throws InterruptedException {

        int normalMusteri = random.nextInt(7) + 1;
        int oncelikliMusteri = random.nextInt(3) + 1;

        for (int i = 0; i < oncelikliMusteri; i++) {
            Musteri musteri = new Musteri("Öncelikli Musteri-" + (sayac + 1));
            musteri.setOncelikliMi(true);
            Masa.musteriEkle(musteri);
            sayac++;
        }

        for (int i = 0; i < normalMusteri; i++) {
            Musteri musteri = new Musteri("Musteri-" + (sayac + 1));
            musteri.setOncelikliMi(false);
            Masa.musteriEkle(musteri);
            sayac++;
        }
    }

    @Override
    public void run() {
        while (true) {
            try {
                olustur();
                sleep(25000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
