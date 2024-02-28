import java.util.LinkedList;

public class Musteri{
    String name;
    private boolean oncelikliMi;
    private boolean siparisAlindiMi;
    private boolean odemeYapildiMi;

    public boolean isYemegiBittiMi() {
        return yemegiBittiMi;
    }

    public void setYemegiBittiMi(boolean yemegiBittiMi) {
        this.yemegiBittiMi = yemegiBittiMi;
    }

    private boolean yemegiBittiMi;

    public boolean isOdemeYapildiMi() {
        return odemeYapildiMi;
    }

    public void setOdemeYapildiMi(boolean odemeYapildiMi) {
        this.odemeYapildiMi = odemeYapildiMi;
    }

    private boolean yemekYiyorMu;
    private boolean yemegiHazirMi;

    public boolean isYemegiHazirMi() {
        return yemegiHazirMi;
    }

    public void setYemegiHazirMi(boolean yemegiHazirMi) {
        this.yemegiHazirMi = yemegiHazirMi;
    }

    public boolean isOturuyorMu() {
        return oturuyorMu;
    }

    public void setOturuyorMu(boolean oturuyorMu) {
        this.oturuyorMu = oturuyorMu;
    }

    private boolean oturuyorMu;

    public Masa getOturduguMasa() {
        return oturduguMasa;
    }

    public void setOturduguMasa(Masa oturduguMasa) {
        this.oturduguMasa = oturduguMasa;
    }

    private Masa oturduguMasa;

    public boolean isSiparisAlindiMi() {
        return siparisAlindiMi;
    }

    public void setSiparisAlindiMi(boolean siparisAlindiMi) {
        this.siparisAlindiMi = siparisAlindiMi;
    }

    public boolean isOncelikliMi() {
        return oncelikliMi;
    }

    public boolean isYemekYiyorMu() {
        return yemekYiyorMu;
    }

    public void setYemekYiyorMu(boolean yemekYiyorMu) {
        this.yemekYiyorMu = yemekYiyorMu;
    }

    public void setOncelikliMi(boolean oncelikliMi) {
        this.oncelikliMi = oncelikliMi;
    }

    Musteri(String name){
        this.name = name;
        siparisAlindiMi = false;
        odemeYapildiMi = false;
        yemekYiyorMu = false;
        yemegiHazirMi = false;
        yemegiBittiMi = false;
    }

}
