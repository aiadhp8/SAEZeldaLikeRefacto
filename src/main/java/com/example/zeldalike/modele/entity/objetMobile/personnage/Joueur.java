package com.example.zeldalike.modele.entity.objetMobile.personnage;

import com.example.zeldalike.modele.entity.Position;

public class Joueur extends Personnage{

    private Inventaire inventaire;

    public Joueur(Position position, int direction, int vitesse, int hp, Inventaire inventaire) {
        super(position, direction, vitesse, hp);
        this.inventaire = inventaire;
    }
}
