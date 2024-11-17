package com.example.zeldalike.modele.entity.objetMobile.personnage.ennemi;

import com.example.zeldalike.modele.Environnement;
import com.example.zeldalike.modele.entity.Position;
import com.example.zeldalike.modele.entity.objetMobile.personnage.Personnage;
import com.example.zeldalike.modele.entity.objetMobile.personnage.deplacements.StrategieDeplacements;
import com.example.zeldalike.modele.entity.objetMobile.personnage.ennemi.loot.FabriqueLoot;

public abstract class Ennemis extends Personnage {
    private static int id = 0;
    private final String idEnnemi;

    private int def;
    private boolean bouclierActif;

    private FabriqueLoot loot;
    private StrategieDeplacements deplacement;

    public Ennemis(Position position, int vitesse, int hp, int def, StrategieDeplacements deplac, FabriqueLoot loot) {
        super(position, vitesse, hp);
        this.idEnnemi = "E" + id;
        id++;
        this.def = def;
        this.bouclierActif = false;
        this.deplacement = deplac;
        this.loot = loot;
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

    public void changerDirection(){
        this.setDirection(this.deplacement.nouvelleDirection(this.getDirection(), this.getPosition()));
    }

    public void agir(){
        changerDirection();
        move();
    }

    public abstract void compétence();

    public abstract void désacCompétence();

    public void dropObjet() {
        Environnement.getInstance().ajouterObjet(this.loot.creerObjetRecuperable(this.getPosition()));
    }

    public String getIdEnnemi() {
        return idEnnemi;
    }
}
