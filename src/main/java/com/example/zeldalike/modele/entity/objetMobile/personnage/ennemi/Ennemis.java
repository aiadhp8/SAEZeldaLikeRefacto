package com.example.zeldalike.modele.entity.objetMobile.personnage.ennemi;

import com.example.zeldalike.modele.entity.Position;
import com.example.zeldalike.modele.entity.objetMobile.personnage.Personnage;
import com.example.zeldalike.modele.entity.objetMobile.personnage.deplacements.StrategieDeplacements;

public abstract class Ennemis extends Personnage {
    private static int id = 0;
    private final String idEnnemi;

    private int def;
    private boolean bouclierActif;

    public Ennemis(Position position, int vitesse, int hp, int def, StrategieDeplacements deplac) {
        super(position, vitesse, hp, deplac);
        this.idEnnemi = "E" + id;
        id++;
        this.def = def;
        this.bouclierActif = false;
        setDirection(6);
    }

    public boolean isBouclierActif() {
        return bouclierActif;
    }

    public int getDef() {
        return def;
    }

    public void setBouclierActif(boolean bouclierActif) {
        this.bouclierActif = bouclierActif;
    }

    public void agir(){
        changerDirection();
        move();
    }

    public abstract void compétence();

    public abstract void désacCompétence();

    public void dropObjet() {}

    public String getIdEnnemi() {
        return idEnnemi;
    }
}
