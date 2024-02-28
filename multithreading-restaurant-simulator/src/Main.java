public class Main {
    public static void main(String[] args) {

        new Restaurant();

        MusteriOlustur musteriThread = new MusteriOlustur();
        musteriThread.start();

        new Arayuz();

    }
}