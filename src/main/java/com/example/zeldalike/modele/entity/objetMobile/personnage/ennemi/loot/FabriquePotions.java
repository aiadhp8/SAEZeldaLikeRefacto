package com.example.zeldalike.modele.entity.objetMobile.personnage.ennemi.loot;

import com.example.zeldalike.modele.entity.Position;
import com.example.zeldalike.modele.entity.objetImmobile.objetRecuperable.ObjetRecuperables;
import com.example.zeldalike.modele.entity.objetImmobile.objetRecuperable.potion.PotionVitale;

public class FabriquePotions implements FabriqueLoot{

    public FabriquePotions(){}

    @Override
    public ObjetRecuperables creerObjetRecuperable(Position p) {
        return new PotionVitale(p);
    }
}
