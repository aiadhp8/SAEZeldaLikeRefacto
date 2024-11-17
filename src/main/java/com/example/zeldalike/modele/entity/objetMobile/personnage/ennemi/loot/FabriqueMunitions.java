package com.example.zeldalike.modele.entity.objetMobile.personnage.ennemi.loot;

import com.example.zeldalike.modele.entity.Position;
import com.example.zeldalike.modele.entity.objetImmobile.objetRecuperable.ObjetRecuperables;
import com.example.zeldalike.modele.entity.objetImmobile.objetRecuperable.arme.gun.Munition;

public class FabriqueMunitions implements FabriqueLoot{

    public FabriqueMunitions(){}

    @Override
    public ObjetRecuperables creerObjetRecuperable(Position p) {
        return new Munition(p);
    }
}
