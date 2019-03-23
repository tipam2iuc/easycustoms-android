package com.example.lyrad_lerbac.easycustom;

public class SousCategory {

    private String nom;
    private  int image;

    public SousCategory(String nom, int image) {
        this.nom = nom;
        this.image = image;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return getNom();
    }

}
