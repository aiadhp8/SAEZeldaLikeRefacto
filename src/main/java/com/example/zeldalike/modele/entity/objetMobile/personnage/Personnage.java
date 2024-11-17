package com.example.zeldalike.modele.entity.objetMobile.personnage;

import com.example.zeldalike.modele.Environnement;
import com.example.zeldalike.modele.entity.Position;
import com.example.zeldalike.modele.entity.objetMobile.ObjetMobile;
import com.example.zeldalike.modele.entity.objetMobile.personnage.deplacements.StrategieDeplacements;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

public abstract class Personnage extends ObjetMobile {
    
    private IntegerProperty hp;
    
    public Personnage(Position position, int vitesse, int hp, StrategieDeplacements deplac) {
        super(position, vitesse, deplac);
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
        int dx = p1.getPosition().getX() - p2.getPosition().getX();
        int dy = p1.getPosition().getY() - p2.getPosition().getY();
        int distance = p1.distance(p2);

        if (distance == 0) return;

        int repulsionForce = 16;
        int[] forcesRepulsion = calculerForcesRepulsion(dx, dy, distance, repulsionForce);
        int repulsionX = forcesRepulsion[0];
        int repulsionY = forcesRepulsion[1];

        deplacerPersonnagesSiPossible(p1, p2, repulsionX, repulsionY);
    }

    private static int[] calculerForcesRepulsion(int dx, int dy, int distance, int force) {
        int repulsionX = (dx / distance) * force;
        int repulsionY = (dy / distance) * force;
        return new int[]{repulsionX, repulsionY};
    }

    private static void deplacerPersonnagesSiPossible(Personnage p1, Personnage p2, int repulsionX, int repulsionY) {
        boolean p1CanMove = canMove(p1, repulsionX, repulsionY);
        boolean p2CanMove = canMove(p2, -repulsionX, -repulsionY);

        if (p1CanMove && p2CanMove) {
            deplacerPersonnage(p1, repulsionX, repulsionY);
            deplacerPersonnage(p2, -repulsionX, -repulsionY);
        } else if (p1CanMove) {
            deplacerPersonnage(p1, repulsionX, repulsionY);
        } else if (p2CanMove) {
            deplacerPersonnage(p2, -repulsionX, -repulsionY);
        }
    }

    private static void deplacerPersonnage(Personnage personnage, int dx, int dy) {
        personnage.getPosition().setX(personnage.getPosition().getX() + dx);
        personnage.getPosition().setY(personnage.getPosition().getY() + dy);
    }


    private static boolean canMove(Personnage p, int deltaX, int deltaY) {
        int x = p.getPosition().getX();
        int y = p.getPosition().getY();
        int height = p.getHeight();
        int width = p.getWidth();

        return Environnement.getInstance().getTerrain().estAutorisé(x + deltaX, y + deltaY) &&
                Environnement.getInstance().getTerrain().estAutorisé(x + height + deltaX, y + deltaY) &&
                Environnement.getInstance().getTerrain().estAutorisé(x + deltaX, y + width + deltaY) &&
                Environnement.getInstance().getTerrain().estAutorisé(x + height + deltaX, y + width + deltaY);
    }

    public abstract void subirDegats(int degats);

    public abstract void recevoirSoins(int pv);
}
