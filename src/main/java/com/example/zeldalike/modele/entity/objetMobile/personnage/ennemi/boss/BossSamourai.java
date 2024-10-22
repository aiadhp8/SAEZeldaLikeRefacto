package com.example.zeldalike.modele.entity.objetMobile.personnage.ennemi.boss;

import com.example.zeldalike.modele.entity.Position;

public class BossSamourai extends Boss {
    public BossSamourai(Position position, int direction, int vitesse, int hp, int def, ArrayList<ObjetRecuperable> loot) {
        super(position, direction, vitesse, hp, def, loot);
    }
}
