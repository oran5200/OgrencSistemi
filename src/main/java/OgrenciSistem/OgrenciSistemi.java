package OgrenciSistem;

import  java.util.ArrayList;
import  java.util.Scanner;



class Ogrenci {
    int id;
    String ad;
    String soyad;
    int notu;

    public Ogrenci(int id, String ad, String soyad, int notu) {
        this.id = id;
        this.ad = ad;
        this.soyad = soyad;
        this.notu = notu;
    }

    @Override
    public String toString() {
        return "ID: " + id + ", " + ad + " " + soyad + ", Not: " + notu;
    }
}

public class OgrenciSistemi {
    static ArrayList<Ogrenci> ogrenciler = new ArrayList<>();
    static Scanner scanner=new Scanner(System.in);
    static int nextId =1;

    public static void main(String[] args) throws InterruptedException {

        System.out.println("=== Öğrenci Kayıt Sistemi ==="); // başlık

        while (true){  // Sonsuz döngü
            // menü secenekleri yazdırma
            System.out.println("\n1: Öğrenci Ekle");
            System.out.println("2: Öğrencileri Listele");
            System.out.println("3: Temizle");
            System.out.println("4: Çıkış");
            System.out.println("Seçiminiz: "); // sayı bekle

            // seçim okuma int
            int secim = scanner.nextInt();
            scanner.nextLine();

            //if else ile secim yapma
            if (secim==1){
                // ad soyad okuma
                System.out.println("Ad: ");
                String ad=scanner.nextLine();

                System.out.println("Soyad: ");
                String soyad=scanner.nextLine();

                System.out.println("Notu: ");
                int notu=scanner.nextInt();
                scanner.nextLine();

                if (notu < 0 || notu > 100) {
                    System.out.println("Not 0-100 arasında olmalı!");
                    continue;
                }
                if (ad.isEmpty() || soyad.isEmpty()) {
                    System.out.println("Ad Soyad boş olamaz!");
                    continue;
                }
                Ogrenci yeniogrenci = new Ogrenci(nextId, ad, soyad, notu);
                ogrenciler.add(yeniogrenci);
                System.out.println("Öğrenci eklendi! ID: " + (nextId++));



            } else if (secim==2) {

                if (ogrenciler.isEmpty()) {
                    System.out.println("Liste boş! Önce öğrenci ekleyin.");
                } else {
                    System.out.println("\n---Öğrenci Listesi---");
                    for (Ogrenci ogr: ogrenciler) {
                        System.out.println(ogr);
                    }
                    System.out.println("---Liste Sonu---");


                }
            } else if (secim==3) {
                // temizleme işlemi
                ogrenciler.clear();
                nextId = 1; // id sıfırlama
                System.out.println("Liste Temizlendi");
            } else if (secim==4) {
                System.out.println("Çıkış yapılıyor...");
                break;
            } else {
                System.out.println("Geçersiz seçim! 1-4 arasında seçim yapın.");
            }

        }
        scanner.close();
    }
}
