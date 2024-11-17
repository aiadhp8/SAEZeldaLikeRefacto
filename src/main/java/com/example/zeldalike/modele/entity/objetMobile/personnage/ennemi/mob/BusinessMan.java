package com.example.zeldalike.modele.entity.objetMobile.personnage.ennemi.mob;

import com.example.zeldalike.modele.entity.Position;
import com.example.zeldalike.modele.entity.objetImmobile.objetRecuperable.ObjetRecuperables;

public class BusinessMan extends Mob {

    public BusinessMan(Position position) {
        super(position, 1, 40, 3, null);
    }

    @Override
    public void compétence() {

    }

    @Override
    public void désacCompétence() {

    }


    @Override
    public void recevoirSoins(int pv) {

    }
}
