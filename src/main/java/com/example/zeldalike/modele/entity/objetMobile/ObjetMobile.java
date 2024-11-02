package com.example.zeldalike.modele.entity.objetMobile;

import com.example.zeldalike.modele.Environnement;
import com.example.zeldalike.modele.entity.*;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;


public abstract class ObjetMobile extends Entity {
    private IntegerProperty direction;
    private int vitesse;

    public ObjetMobile(Position position, int vitesse) {
        super(position);
        this.direction = new SimpleIntegerProperty();
        this.vitesse = vitesse;
    }

    public int getDirection() {
        return direction.get();
    }

    public IntegerProperty directionProperty() {
        return direction;
    }

    public void setDirection(int direction) {
        this.direction.set(direction);
    }

    public int getVitesse() {
        return vitesse;
    }

    public void setVitesse(int vitesse) {
        this.vitesse = vitesse;
    }


    public void move() {
        int deltaX = 0;
        int deltaY = 0;

        switch (this.getDirection()) {
            case 1:
                deltaX = -1;
                deltaY = 1;
                break;
            case 2:
                deltaY = 1;
                break;
            case 3:
                deltaX = 1;
                deltaY = 1;
                break;
            case 4:
                deltaX = -1;
                break;
            case 6:
                deltaX = 1;
                break;
            case 7:
                deltaX = -1;
                deltaY = -1;
                break;
            case 8:
                deltaY = -1;
                break;
            case 9:
                deltaX = 1;
                deltaY = -1;
                break;
            case 5:
                return; // Pas de mouvement
        }

        move(deltaX, deltaY);

        // TODO : positionPre ???

    }

    private void move(int deltaX, int deltaY) {
        double nouvellePosX = this.getPosition().getX() + deltaX * this.getVitesse();
        double nouvellePosY = this.getPosition().getY() + deltaY * this.getVitesse();

        int newX = (int) Math.round(nouvellePosX);
        int newY = (int) Math.round(nouvellePosY);

        if (Environnement.getInstance().getTerrain().estDansTerrain(newX, newY) &&
                Environnement.getInstance().getTerrain().estAutorisé(newX + this.getWidth(), newY) &&
                Environnement.getInstance().getTerrain().estAutorisé(newX, newY + this.getHeight())) {

            this.getPosition().setX(newX);
            this.getPosition().setY(newY);
        }
    }
}

