package com.example.zeldalike.modele.entity.objetMobile.personnage;

import com.example.zeldalike.modele.entity.Position;
import com.example.zeldalike.modele.entity.objetMobile.ObjetMobile;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

public abstract class Personnage extends ObjetMobile {
    
    private IntegerProperty hp;
    
    public Personnage(Position position, int vitesse, int hp) {
        super(position, vitesse);
        this.hp = new SimpleIntegerProperty(hp);
    }

    public int getHp() {
        return hp.get();
    }

    public void setHp(int hp) {
        this.hp.set(hp);
    }

    public IntegerProperty hpProperty() {
        return hp;
    }

    public boolean enVie() {
        return this.getHp() > 0;
    }

    public static void repousserPersonnages(Personnage p1, Personnage p2) {
        int dx = p1.getP().getX() - p2.getP().getX();
        int dy = p1.getP().getY() - p2.getP().getY();
        int distance = p1.distanceEntreDeuxPersonnages(p1, p2);
        if (distance == 0) return;

        int repulsionForce = 16;
        int repulsionX = (dx / distance) * repulsionForce;
        int repulsionY = (dy / distance) * repulsionForce;

        boolean p1CanMove = canMove(p1, repulsionX, repulsionY);
        boolean p2CanMove = canMove(p2, -repulsionX, -repulsionY);

        if (p1CanMove && p2CanMove) {
            p1.moveDe(repulsionX, repulsionY);
            p2.moveDe(-repulsionX, -repulsionY);
        } else if (p1CanMove) {
            p1.moveDe(repulsionX, repulsionY);
        } else if (p2CanMove) {
            p2.moveDe(-repulsionX, -repulsionY);
        }
    }

    private static boolean canMove(Personnage p, int deltaX, int deltaY) {
        int x = p.getP().getX();
        int y = p.getP().getY();
        int hitbox = p.getHitbox();

        return terrain.estAutorisé(x + deltaX, y + deltaY) &&
                terrain.estAutorisé(x + hitbox + deltaX, y + deltaY) &&
                terrain.estAutorisé(x + deltaX, y + hitbox + deltaY) &&
                terrain.estAutorisé(x + hitbox + deltaX, y + hitbox + deltaY);
    }

    public abstract void subirDegats(int degats);

    public abstract void recevoirSoins(int pv);
}
