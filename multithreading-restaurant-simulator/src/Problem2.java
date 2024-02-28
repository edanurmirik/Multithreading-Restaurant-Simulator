public class Problem2 {
    private int zaman;
    private int musteriGelmeSikligi;
    private int masaMaliyeti;
    private int garsonMaliyeti;
    private int asciMaliyeti;
    private int musteriKazanci;
    public int maksimumGelir = 0;
    public int enIyiMasa = 0;
    public int enIyiGarson = 0;
    public int enIyiAsci = 0;
    public int maxMusteriSayisi=0;

    public Problem2(int toplamZaman, int musteriGelmeSikligi, int masaMaliyeti, int musteriMaliyeti, int asciMaliyeti, int musteriKazanci) {
        this.zaman = toplamZaman;
        this.musteriGelmeSikligi = musteriGelmeSikligi;
        this.masaMaliyeti = masaMaliyeti;
        this.garsonMaliyeti = musteriMaliyeti;
        this.asciMaliyeti = asciMaliyeti;
        this.musteriKazanci = musteriKazanci;
    }

    public void eniyidurum() {

        for (int masalar = 1; masalar <= zaman; masalar++) {
            for (int garsonlar = 1; garsonlar <= zaman; garsonlar++) {
                for (int ascilar = 1; ascilar <= zaman; ascilar++) {
                    int simdikiMusteriSayisi = musteriGelmeSikligi * masalar * garsonlar * ascilar;
                    int toplamMaliyet = (masaMaliyeti * masalar) + (garsonMaliyeti * garsonlar) + (asciMaliyeti * ascilar);
                    int toplamKazanc = simdikiMusteriSayisi * musteriKazanci;
                    int kar = toplamKazanc - toplamMaliyet;

                    if (simdikiMusteriSayisi <= zaman && kar > maksimumGelir) {
                        maksimumGelir = kar;
                        enIyiMasa = masalar;
                        enIyiGarson = garsonlar;
                        enIyiAsci = ascilar;
                        maxMusteriSayisi=simdikiMusteriSayisi;
                    }
                }
            }
        }

        System.out.println("EN İYİ DURUM");
        System.out.println("Masa Sayısı: " + enIyiMasa);
        System.out.println("Garson Sayısı: " + enIyiGarson);
        System.out.println("Aşci Sayısı: " + enIyiAsci);
        System.out.println("En Fazla Kazanç: " + maksimumGelir);
        System.out.println(maxMusteriSayisi);
    }
}
