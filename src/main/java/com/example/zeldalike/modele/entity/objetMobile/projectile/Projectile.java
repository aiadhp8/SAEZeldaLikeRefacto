package com.example.zeldalike.modele.entity.objetMobile.projectile;

import com.example.zeldalike.modele.Environnement;
import com.example.zeldalike.modele.entity.objetMobile.ObjetMobile;
import com.example.zeldalike.modele.entity.*;
import com.example.zeldalike.modele.entity.objetMobile.personnage.deplacements.DeplacementAleatoires;
import com.example.zeldalike.modele.entity.objetMobile.personnage.deplacements.DeplacementLigneDroite;

public abstract class Projectile extends ObjetMobile {
    private static int id = 0;
    private final String idProjo;

    protected int degats;

    public Projectile(Position position, int direction, int vitesse, int degats) {
        super(position, vitesse);
        this.idProjo = "P" + id;
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

    protected void move(int deltaX, int deltaY) {
        double nouvellePosX = this.getPosition().getX() + deltaX * this.getVitesse();
        double nouvellePosY = this.getPosition().getY() + deltaY * this.getVitesse();

        int newX = (int) Math.round(nouvellePosX);
        int newY = (int) Math.round(nouvellePosY);


        this.getPosition().setX(newX);
        this.getPosition().setY(newY);

    }
}
