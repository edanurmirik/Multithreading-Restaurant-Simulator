import java.util.ArrayList;

public class Restaurant {
    public final static ArrayList<Garson> garsonlar = new ArrayList<>();
    public final static ArrayList<Asci> ascilar = new ArrayList<>();
    public final static ArrayList<Masa> masalar = new ArrayList<>();
    public final static Kasiyer kasiyer = new Kasiyer("Kasiyer");

    Restaurant()
    {
        for (int i = 0; i < 3; i++)
        {
            garsonlar.add(new Garson("Garson-" + (i+1)));
        }

        for (int i = 0; i < 2; i++)
        {
            ascilar.add(new Asci("Asci-" + (i+1)));
        }

        for (int i = 0; i < 6; i++)
        {
            masalar.add(new Masa("Masa-" + (i+1)));
        }

        for (Masa masa : masalar) {
            masa.start();
        }
        for (Garson garson : garsonlar) {
            garson.start();
        }
        for (Asci asci : ascilar) {
            asci.start();
        }
        for (Masa masa : masalar){
            YemekYe yemek = new YemekYe(masa);
            yemek.start();
        }
        kasiyer.start();
    }
}
