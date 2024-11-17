package com.example.zeldalike.modele.entity.objetMobile.personnage.ennemi.mob;

import com.example.zeldalike.modele.entity.Position;
import com.example.zeldalike.modele.entity.objetImmobile.objetRecuperable.ObjetRecuperables;
import com.example.zeldalike.modele.entity.objetMobile.personnage.deplacements.DeplacementImmobile;
import com.example.zeldalike.modele.entity.objetMobile.personnage.ennemi.loot.FabriqueMunitions;

public class Macarena extends Mob{

    public Macarena(Position position) {
        super(position, 0, 50, 5,new FabriqueMunitions(), new DeplacementImmobile());
    }

    @Override
    public void compétence() {

    }

    @Override
    public void désacCompétence() {

    }

    @Override
    public void subirDegats(int degats) {

    }

    @Override
    public void recevoirSoins(int pv) {

    }
}
