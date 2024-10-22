package com.example.zeldalike.modele.entity.objetMobile;

import com.example.zeldalike.modele.entity.*;


public abstract class ObjetMobile extends Entity {
    protected int direction;
    protected int vitesse;

    public ObjetMobile(Position position, int direction, int vitesse) {
        super(position);
        this.direction = direction;
        this.vitesse = vitesse;
    }

    //TODO Méthodes de déplacement
}

