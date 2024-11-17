package com.example.zeldalike.modele.entity.objetMobile.personnage.ennemi.loot;

import com.example.zeldalike.modele.entity.Position;
import com.example.zeldalike.modele.entity.objetImmobile.objetRecuperable.ObjetRecuperables;

public interface FabriqueLoot {
    public ObjetRecuperables creerObjetRecuperable(Position p);

}
