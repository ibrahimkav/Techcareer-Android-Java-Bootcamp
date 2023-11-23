package com.example.techcareerandroidjavabootcamp.odev;

public class Odev2 {
        public double milDonusturucu(int km){
            double mil = km*0.621;
            return mil;
        }
        public void diktorgenAlani(int kenar1,int kenar2){
            int alan = kenar1*kenar2;
            System.out.println("Alan : "+alan);
        }
        public int faktoriyelHesap(int sayi){
            int hesap=1;
            for(int i = 1;i<=sayi;i++){
                hesap*=i;
            }
            return hesap;
        }
        public void eharfBulucu(String kelime){
           String kucuk = kelime.toLowerCase();
           int adet=0;
            for(int i = 0;i<kucuk.length();i++){
                if(kucuk.charAt(i)=='e'){
                    adet++;
                }
            }
            if(adet==0){
                System.out.println("Kelimenin içinde e bulunamadı.");
            }
            else{
                System.out.println(adet+" Adet e bulundu.");
            }
        }
        public void icAciHesaplama(int kenar){
            int toplami = (kenar -2)*180;
            System.out.println("İç Açılarının Toplamı "+toplami);
        }

        public void maasHesap(int gun){
            int toplamSaat = gun*8;
            if(toplamSaat>150){
                int mesaiSaat = toplamSaat-150;
                int toplamMaas = (150*40)+(mesaiSaat*80);
                System.out.println("Çalıştığınız Gün "+ gun +" 'e Göre Toplam : "+toplamMaas+" Kazandınız.");
            return;
            }
            else {
                int maas = 150*40;
                System.out.println("Çalıştığınız Gün "+ gun +" 'e Göre Toplam : "+maas+" Kazandınız.");
            }
        }
        public int otoparkUcretHesapla(int saat){
            int toplamUcret =0;
            if(saat>=1){
                toplamUcret = (saat-1)*10+50;
                return toplamUcret;
            }
            else {
                System.out.println("Geçersiz giriş.");
            }
            return toplamUcret;
        }
}
