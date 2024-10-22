package com.example.zeldalike.modele.entity.objetMobile.personnage.ennemi.boss;

import com.example.zeldalike.modele.entity.Position;
import com.example.zeldalike.modele.entity.objetMobile.personnage.ennemi.Ennemi;

public abstract class Boss extends Ennemi {

    private ArrayList<ObjetRecuperable> loot;

    public Boss(Position position, int direction, int vitesse, int hp, int def, ArrayList<ObjetRecuperable> loot) {
        super(position, direction, vitesse, hp, def);
        this.loot = loot;
    }
}
