package com.meineapp.kabbamobeldesign.Entities;

public class Product {
    private String name;
    private String beschreibung;
    private String preis;
    private int imageRef;

    public Product (String name, String beschreibung, String preis, int imageRef) {
        this.name = name;
        this.beschreibung = beschreibung;
        this.preis = preis;
        this.imageRef = imageRef;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBeschreibung() {
        return beschreibung;
    }

    public void setBeschreibung(String beschreibung) {
        this.beschreibung = beschreibung;
    }

    public String getPreis() {
        return preis;
    }

    public void setPreis(String preis) {
        this.preis = preis;
    }

    public int getImageRef() {
        return imageRef;
    }

    public void setImageRef(int imageRef) {
        this.imageRef = imageRef;
    }
}
