package com.example.zeldalike.modele.entity.objetMobile.personnage.ennemi.mob;

import com.example.zeldalike.modele.entity.Position;
import com.example.zeldalike.modele.entity.objetImmobile.objetRecuperable.ObjetRecuperables;
import com.example.zeldalike.modele.entity.objetMobile.personnage.deplacements.StrategieDeplacements;
import com.example.zeldalike.modele.entity.objetMobile.personnage.ennemi.Ennemis;
import com.example.zeldalike.modele.entity.objetMobile.personnage.ennemi.loot.FabriqueLoot;

public abstract class Mob extends Ennemis {

    public Mob(Position position, int vitesse, int hp, int def, FabriqueLoot loot, StrategieDeplacements deplac) {
        super(position, vitesse, hp, def, deplac, loot);
    }

    public void subirDegats(int degats) {
        this.setHp(this.getHp() - degats);
        System.out.println(getHp());
    }
}
