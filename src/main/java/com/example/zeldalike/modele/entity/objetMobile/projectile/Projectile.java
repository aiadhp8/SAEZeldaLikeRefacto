package com.example.zeldalike.modele.entity.objetMobile.projectile;

import com.example.zeldalike.modele.entity.objetMobile.ObjetMobile;
import com.example.zeldalike.modele.entity.*;

public abstract class Projectile extends ObjetMobile {
    protected int degats;

    public Projectile(Position position, int direction, int vitesse, int degats) {
        super(position, vitesse);
        this.degats = degats;
        this.setDirection(direction);
    }


}
