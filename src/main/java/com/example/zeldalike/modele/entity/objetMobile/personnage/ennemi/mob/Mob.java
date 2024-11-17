package com.example.zeldalike.modele.entity.objetMobile.personnage.ennemi.mob;

import com.example.zeldalike.modele.entity.Position;
import com.example.zeldalike.modele.entity.objetImmobile.objetRecuperable.ObjetRecuperables;
import com.example.zeldalike.modele.entity.objetMobile.personnage.deplacements.StrategieDeplacements;
import com.example.zeldalike.modele.entity.objetMobile.personnage.ennemi.Ennemis;

public abstract class Mob extends Ennemis {

    private ObjetRecuperables loot;

    public Mob(Position position, int vitesse, int hp, int def, ObjetRecuperables loot, StrategieDeplacements deplac) {
        super(position, vitesse, hp, def, deplac);
        this.loot = loot;
    }

    public void subirDegats(int degats) {
        this.setHp(this.getHp() - degats);
        System.out.println(getHp());
    }
}
