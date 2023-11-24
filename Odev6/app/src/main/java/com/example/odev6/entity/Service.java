package com.example.odev6.entity;

public class Service {
    private int service_id;
    private String service_ad;
    private String resim_ad;

    public Service() {
    }

    public Service(int service_id, String service_ad, String resim_ad) {
        this.service_id = service_id;
        this.service_ad = service_ad;
        this.resim_ad = resim_ad;
    }

    public int getService_id() {
        return service_id;
    }

    public void setService_id(int service_id) {
        this.service_id = service_id;
    }

    public String getService_ad() {
        return service_ad;
    }

    public void setService_ad(String service_ad) {
        this.service_ad = service_ad;
    }

    public String getResim_ad() {
        return resim_ad;
    }

    public void setResim_ad(String resim_ad) {
        this.resim_ad = resim_ad;
    }
}
