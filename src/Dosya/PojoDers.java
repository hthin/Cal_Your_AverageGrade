package Dosya;

public class PojoDers {

    private String ogrenciAdi;
    private int ogrenciNo;
    private String dersAdi ;
    private int vizeNot;
    private int finalNot;
    private double notOrtalama;

    public PojoDers(String ogrenciAdi, int ogrenciNo, String dersAdi, int vizeNot, int finalNot, double notOrtalama) {
        this.ogrenciAdi = ogrenciAdi;
        this.ogrenciNo = ogrenciNo;
        this.dersAdi = dersAdi;
        this.vizeNot = vizeNot;
        this.finalNot = finalNot;
        this.notOrtalama = notOrtalama;
    }

    public PojoDers() {
    }

    public int getOgrenciNo() {
        return ogrenciNo;
    }

    public void setOgrenciNo(int ogrenciNo) {
        this.ogrenciNo = ogrenciNo;
    }

    public String getOgrenciAdi() {
        return ogrenciAdi;
    }

    public void setOgrenciAdi(String ogrenciAdi) {
        this.ogrenciAdi = ogrenciAdi;
    }

    public String getDersAdi() {
        return dersAdi;
    }

    public void setDersAdi(String dersAdi) {
        this.dersAdi = dersAdi;
    }

    public int getVizeNot() {
        return vizeNot;
    }

    public void setVizeNot(int vizeNot) {
        this.vizeNot = vizeNot;
    }

    public int getFinalNot() {
        return finalNot;
    }

    public void setFinalNot(int finalNot) {
        this.finalNot = finalNot;
    }

    public double getNotOrtalama() {
        return notOrtalama;
    }

    public void setNotOrtalama(double notOrtalama) {
        this.notOrtalama = notOrtalama;
    }

}
