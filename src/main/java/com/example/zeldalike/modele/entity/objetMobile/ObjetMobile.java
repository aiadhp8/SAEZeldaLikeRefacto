package com.example.zeldalike.modele.entity.objetMobile;

import com.example.zeldalike.modele.Environnement;
import com.example.zeldalike.modele.entity.*;
import com.example.zeldalike.modele.entity.objetMobile.personnage.deplacements.StrategieDeplacements;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;


public abstract class ObjetMobile extends Entity {
    private final IntegerProperty direction;
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
                return;
        }

        move(deltaX, deltaY);

        // TODO : positionPre ???

    }

    protected abstract void move(int deltaX, int deltaY);
}

