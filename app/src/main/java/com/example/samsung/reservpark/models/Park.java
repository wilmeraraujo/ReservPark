package com.example.samsung.reservpark.models;

public class Park {
    private int id;
    private String name;
    private String address;
    private int quota;
    private int tariff;
    private String horary;

    public Park(int id, String name, String address, int quota, int tariff, String horary) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.quota = quota;
        this.tariff = tariff;
        this.horary = horary;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getQuota() {
        return quota;
    }

    public void setQuota(int quota) {
        this.quota = quota;
    }

    public int getTariff() {
        return tariff;
    }

    public void setTariff(int tariff) {
        this.tariff = tariff;
    }

    public String getHorary() {
        return horary;
    }

    public void setHorary(String horary) {
        this.horary = horary;
    }
}
