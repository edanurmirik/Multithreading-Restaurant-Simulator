import java.util.ArrayList;
import java.util.LinkedList;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class Asci extends Thread {
    public String name;
    private static BlockingQueue<Musteri> musteriSiparis1 = new LinkedBlockingQueue<>();
    private static BlockingQueue<Musteri> musteriSiparis2 = new LinkedBlockingQueue<>();
    public boolean calisiyor;
    public ArrayList<Musteri> siparisListesi = new ArrayList<>();

    public Asci(String name) {
        this.name = name;
        this.calisiyor = false;
    }

    public static void yeniSiparisAl(Musteri musteri) {
        try {
            int musteriNo = Integer.parseInt(musteri.name.substring(musteri.name.indexOf("-")+1));
            if(musteriNo % 2 == 0){
                musteriSiparis2.put(musteri);
            }else {
                musteriSiparis1.put(musteri);
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    void siparisHazirla() throws InterruptedException {

        if(!musteriSiparis1.isEmpty() && musteriSiparis2.isEmpty()){

            Musteri musteri = musteriSiparis1.take();
            this.calisiyor = true;
            siparisListesi.add(musteri);
            System.out.println(name + "; " + musteri.name + " adlı müşterilerin siparişini hazırlıyor.");
            Thread.sleep(3000);
            this.calisiyor = false;
            siparisListesi.clear();
            musteri.setYemegiHazirMi(true);
            System.out.println(name + "; " + musteri.name + " adlı müşterilerin siparişini hazırladı.");
            System.out.println("---------------------------------------------------------");

        }else if(!musteriSiparis2.isEmpty() && musteriSiparis1.isEmpty()){
            Musteri musteri = musteriSiparis2.take();
            this.calisiyor = true;
            siparisListesi.add(musteri);
            System.out.println(name + "; " + musteri.name + " adlı müşterilerin siparişini hazırlıyor.");
            Thread.sleep(3000);
            this.calisiyor = false;
            siparisListesi.clear();
            musteri.setYemegiHazirMi(true);
            System.out.println(name + "; " + musteri.name + " adlı müşterilerin siparişini hazırladı.");
            System.out.println("---------------------------------------------------------");

        }else if(!musteriSiparis1.isEmpty() && !musteriSiparis2.isEmpty()){

            Musteri musteri1 = musteriSiparis1.take();
            Musteri musteri2 = musteriSiparis2.take();

            this.calisiyor = true;
            siparisListesi.add(musteri1);
            siparisListesi.add(musteri2);
            System.out.println(name + "; " + musteri1.name + " ve " + musteri2.name + " adlı müşterilerin siparişini hazırlıyor.");
            Thread.sleep(3000);
            this.calisiyor = false;
            siparisListesi.clear();

            musteri1.setYemegiHazirMi(true);
            musteri2.setYemegiHazirMi(true);

            System.out.println(name + "; " + musteri1.name + " ve " + musteri2.name + " adlı müşterilerin siparişini hazırladı.");
            System.out.println("---------------------------------------------------------");
        }
    }

    @Override
    public void run() {
        while (true) {
            try {
                siparisHazirla();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}