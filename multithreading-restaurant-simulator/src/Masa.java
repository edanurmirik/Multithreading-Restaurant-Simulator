import java.util.LinkedList;

class Masa extends Thread {
    String name;
    private volatile boolean empty;

    public boolean isEmpty() {
        return empty;
    }

    public void setEmpty(boolean empty) {
        this.empty = empty;
    }
    public Musteri oturanMusteri;
    static LinkedList<Musteri> bekleyenMusteriler = new LinkedList<>();

    Masa(String name) {
        this.name = name;
        this.empty = true;
    }

    public static void musteriEkle(Musteri musteri) {
        synchronized (bekleyenMusteriler) {
            bekleyenMusteriler.add(musteri);
            bekleyenMusteriler.notify(); // Bekleyen kasiyeri uyandır
        }
    }

    void musteriOturt(Musteri musteri) throws InterruptedException {

        synchronized (bekleyenMusteriler) {
            if (this.empty && !bekleyenMusteriler.isEmpty()) {
                bekleyenMusteriler.remove(musteri);
                musteri.setOturuyorMu(true);
                musteri.setOturduguMasa(this);
                oturanMusteri = musteri;
                this.empty = false;
                System.out.println(musteri.name + " masaya oturdu: " + this.name);
                System.out.println("---------------------------------------------------------");
                Garson.musteriEkle(musteri);
            }
        }
    }

    public void musteriKaldir() {
        synchronized (this) {
            if (!this.empty) {
                this.empty = true;
                this.oturanMusteri.setOturuyorMu(false);
                this.oturanMusteri.setOturduguMasa(null);
                System.out.println(this.oturanMusteri.name + " adlı müşteri masadan kalktı: " + this.name);
                System.out.println("---------------------------------------------------------");
            }
        }
    }

    @Override
    public void run() {
        while (true) {
            try {
                synchronized (bekleyenMusteriler) {
                    while (bekleyenMusteriler.isEmpty()) {
                        bekleyenMusteriler.wait();
                    }
                    musteriOturt(bekleyenMusteriler.getFirst());
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}