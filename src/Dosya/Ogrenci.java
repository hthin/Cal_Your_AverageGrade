package Dosya;


import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


public class Ogrenci implements Islemler {
    static Map<String, PojoDers> dersler = new HashMap<>();


    @Override
    public double ortalamaHesapla(int vize, int fNot) {
        double ortalama = (vize * 0.4) + (fNot * 0.6);

        return ortalama;
    }

    @Override
    public void dersEkleme() {

        try {
            Scanner scan = new Scanner(System.in);
            System.out.print("\nÖğrenci Adı ve Soyadı : ");
            String ad = scan.nextLine();

            System.out.print("Oğrenci Numarası : ");
            int ogrenciNo = scan.nextInt();
            scan.nextLine();

            System.out.print("Ders Adı : ");
            String d = scan.nextLine();
            String ders = d.substring(0,1).toUpperCase() + d.substring(1).toLowerCase();

            System.out.print("Vize Notu : ");
            int not1 = scan.nextInt();

            System.out.print("Final Notu : ");
            int not2 = scan.nextInt();

            double ort = ortalamaHesapla(not1, not2); // burda ortalama hesaplama metodu ile ortalamayı bulup geri çağırdım.

            PojoDers obje = new PojoDers(ad, ogrenciNo, ders, not1, not2, ort);


            Ogrenci.dersler.put(ders, obje);
            dosyaYaz();
            System.out.println("\033[0;1mDers kaydı başarıyla eklendi.\u001B[0m");


        } catch (Exception e) {
            System.out.println("Hatalı giriş yaptınız.");
        }


    }

    @Override
    public void dersSilme() {

        try {
            Scanner scan = new Scanner(System.in);

            System.out.print("\nOğrenci numarası giriniz : ");
            int no = scan.nextInt();
            scan.nextLine();

            System.out.print("Hangi dersi silmek istersiniz : ");
            String str = scan.nextLine();
            String str1 = str.substring(0,1).toUpperCase() + str.substring(1).toLowerCase();


            if (Ogrenci.dersler.containsKey(str1) && Ogrenci.dersler.get(str1).getOgrenciNo() == no) {

                System.out.println();
                System.out.println(Ogrenci.dersler.get(str1).getOgrenciAdi()+" adlı öğrenciden "+
                        Ogrenci.dersler.get(str1).getDersAdi()+" dersinin kaydı silindi.");

                Ogrenci.dersler.remove(str1);

                dosyaYaz();


            } else {
                System.out.println("\nBöyle bir öğrenci bulunmamaktadır.");
            }


        } catch (Exception e) {
            System.out.println("Hatalı giriş yaptınız.");
        }

    }

    @Override
    public void listeleme() {
        System.out.println();
        System.out.printf("\033[0;1m\u001B[34m%12s%12s%12s%12s%12s%12s\u001B[0m","Adı Soyadı","Numarası","Ders Adı","Vize Not","Final Not","Ortalama");
        System.out.println();
        for(Map.Entry<String, PojoDers> val: Ogrenci.dersler.entrySet()) {
            System.out.printf("%12s%12d%12s%12d%12d%12.2f",val.getValue().getOgrenciAdi(),val.getValue().getOgrenciNo(),
                    val.getValue().getDersAdi(),val.getValue().getVizeNot(),val.getValue().getFinalNot(),val.getValue().getNotOrtalama());
            System.out.println();
        }

    }

    @Override
    public void dosyaOku() {
        String filePath = System.getProperty("user.dir") + "/dersler.txt";
        File file = new File(filePath);
        if (!file.exists()) { // file yoksa oluşturalım
            try {
                file.createNewFile();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        try {
            FileReader dosya = new FileReader(filePath);
            BufferedReader bReader = new BufferedReader(dosya);
            String line;

            PojoDers obje;
            while ((line = bReader.readLine()) != null) {
                obje = new PojoDers();

                obje.setOgrenciAdi(line.substring(0, 20).trim());
                obje.setOgrenciNo(Integer.parseInt(line.substring(20, 40).trim()));
                obje.setDersAdi(line.substring(40, 60).trim());
                obje.setVizeNot(Integer.parseInt(line.substring(60, 80).trim()));
                obje.setFinalNot(Integer.parseInt(line.substring(80,100).trim()));
                String ss = line.substring(100).trim();
                ss = ss.replace(",","."); // bir yukarıda string sayı 70,78 formatında olduğu için, virgül kısmını nokta yapmak zorunda kaldık.
                obje.setNotOrtalama(Double.parseDouble(ss));

//                if (tahsilatNo < obje.getTahsilatNo()) {
//                    tahsilatNo = obje.getTahsilatNo();
//                }

                Ogrenci.dersler.put(obje.getDersAdi(), obje);

            }
            bReader.close();
            dosya.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            System.out.println(e.toString());
        }

    }

    @Override
    public void dosyaYaz() {
        String filePath = System.getProperty("user.dir") + "/dersler.txt";

        File file = new File(filePath);


        try {

            FileWriter fw = new FileWriter(file);

            BufferedWriter bw = new BufferedWriter(fw);

            for (Map.Entry<String, PojoDers> val : Ogrenci.dersler.entrySet()) {
                String line = String.format("%20s%20d%20s%20d%20d%20.2f", val.getValue().getOgrenciAdi(),
                        val.getValue().getOgrenciNo(), val.getValue().getDersAdi(), val.getValue().getVizeNot(),
                        val.getValue().getFinalNot(), val.getValue().getNotOrtalama());
                bw.write(line); // line stringini yaz
                bw.newLine(); // yeni satır başlat
            }
            bw.close();
            fw.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
