package com.example.techcareerandroidjavabootcamp.odev;

public class Odev2Main {
    public static void main(String[] args) {
        Odev2 odev2 = new Odev2();

       double milDonusturuldu = odev2.milDonusturucu(150);
        System.out.println("Mill : "+milDonusturuldu);
        odev2.diktorgenAlani(15,10);
        int fakHesap = odev2.faktoriyelHesap(5);
        System.out.println("Faktoriyel : "+fakHesap);
        odev2.eharfBulucu("Ahmeet");
        odev2.icAciHesaplama(6);
        odev2.maasHesap(25);
        int otoparkUcret = odev2.otoparkUcretHesapla(20);
        System.out.println("Otopark Ucreti : "+otoparkUcret);

    }

}
