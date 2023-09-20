package Project;

import java.util.Scanner;

public class Runner {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Ogrenci obje = new Ogrenci();
        obje.dosyaOku();


        int secim = 0;
        do {
            try {
                System.out.println();
                System.out.println("\033[0;1m\u001B[36m  *** NOT HESAPLAMA ***  ");
                System.out.println("1 - Ders Eklemek için");
                System.out.println("2 - Ders Silmek için");
                System.out.println("3 - Listelemek için");
                System.out.println("4 - Çıkış için");
                System.out.print("Seçiniz : \u001B[0m");
                secim = scan.nextInt();
                switch (secim) {

                    case 1: obje.dersEkleme() ;break;
                    case 2: obje.dersSilme()  ;break;
                    case 3: obje.listeleme()  ;break;

                }
            } catch (Exception e) {
                System.out.println("Hatalı giriş yaptınız.");
            }


        } while (secim < 4);


    }


}
