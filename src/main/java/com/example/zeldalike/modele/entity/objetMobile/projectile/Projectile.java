package com.example.zeldalike.modele.entity.objetMobile.projectile;

import com.example.zeldalike.modele.entity.objetMobile.ObjetMobile;
import com.example.zeldalike.modele.entity.*;
import com.example.zeldalike.modele.entity.objetMobile.personnage.deplacements.DeplacementLigneDroite;

public abstract class Projectile extends ObjetMobile {
    private static int id = 0;
    private final String idProjo;

    protected int degats;

    public Projectile(Position position, int direction, int vitesse, int degats) {
        super(position, vitesse, new DeplacementLigneDroite());
        this.idProjo = "E" + id;
        id++;
        this.degats = degats;
        this.setDirection(direction);
    }

    public int getDegats() {
        return degats;
    }

    public String getIdProjo() {
        return idProjo;
    }
}
