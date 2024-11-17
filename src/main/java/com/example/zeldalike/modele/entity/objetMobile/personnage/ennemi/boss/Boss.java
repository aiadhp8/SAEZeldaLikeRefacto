package com.example.zeldalike.modele.entity.objetMobile.personnage.ennemi.boss;

import com.example.zeldalike.modele.entity.Position;
import com.example.zeldalike.modele.entity.objetImmobile.objetRecuperable.ObjetRecuperables;
import com.example.zeldalike.modele.entity.objetMobile.personnage.deplacements.DeplacementImmobile;
import com.example.zeldalike.modele.entity.objetMobile.personnage.ennemi.Ennemis;
import com.example.zeldalike.modele.entity.objetMobile.personnage.ennemi.loot.FabriquePotions;

import java.util.ArrayList;

public abstract class Boss extends Ennemis {

    private ArrayList<ObjetRecuperables> loot;

    public Boss(Position position, int vitesse, int hp, int def, ArrayList<ObjetRecuperables> loot) {
        super(position, vitesse, hp, def, new DeplacementImmobile(), new FabriquePotions());
        this.loot = loot;
    }
}
