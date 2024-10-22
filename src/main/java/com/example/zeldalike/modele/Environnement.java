package com.example.zeldalike.modele;

import com.example.zeldalike.modele.entity.objetMobile.personnage.Joueur;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Environnement {

    private static Environnement instance;

    private int heigh;
    private int width;

    private Joueur joueur;

    public Environnement(int heigh, int width) {
        this.heigh = heigh;
        this.width = width;
    }

    public static Environnement getInstance() {
        if (instance == null) {
            instance = new Environnement(2048, 4096);
        }
        return instance;
    }
}
