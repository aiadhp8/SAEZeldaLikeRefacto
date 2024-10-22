package com.example.zeldalike.modele.entity.objetMobile.personnage.ennemi.mob;

import com.example.zeldalike.modele.entity.Position;
import com.example.zeldalike.modele.entity.objetMobile.personnage.ennemi.Ennemi;

public abstract class Mob extends Ennemi {

    private ObjetRecuperable loot;

    public Mob(Position position, int direction, int vitesse, int hp, int def, ObjetRecuperable loot) {
        super(position, direction, vitesse, hp, def);
    }
}
