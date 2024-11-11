package com.example.zeldalike.modele.entity.objetMobile.personnage.ennemi.mob;

import com.example.zeldalike.modele.entity.Position;
import com.example.zeldalike.modele.entity.objetImmobile.objetRecuperable.ObjetRecuperables;
import com.example.zeldalike.modele.entity.objetMobile.personnage.ennemi.Ennemis;

public abstract class Mob extends Ennemis {

    private ObjetRecuperables loot;

    public Mob(Position position, int vitesse, int hp, int def, ObjetRecuperables loot) {
        super(position, vitesse, hp, def);
    }
}
