package com.example.zeldalike.modele.entity.objetMobile.personnage.ennemi;

import com.example.zeldalike.modele.entity.Position;
import com.example.zeldalike.modele.entity.objetMobile.personnage.Personnage;

public abstract class Ennemis extends Personnage {

    private int def;
    private boolean bouclierActif;

    public Ennemis(Position position, int direction, int vitesse, int hp, int def) {
        super(position, direction, vitesse, hp);
        this.def = def;
        this.bouclierActif = false;
    }
}