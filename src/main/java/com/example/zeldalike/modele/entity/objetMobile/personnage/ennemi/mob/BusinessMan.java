package com.example.zeldalike.modele.entity.objetMobile.personnage.ennemi.mob;

import com.example.zeldalike.modele.entity.Position;
import com.example.zeldalike.modele.entity.objetImmobile.objetRecuperable.ObjetRecuperables;
import com.example.zeldalike.modele.entity.objetMobile.personnage.deplacements.DeplacementAleatoireBFS;
import com.example.zeldalike.modele.entity.objetMobile.personnage.deplacements.DeplacementAleatoires;
import com.example.zeldalike.modele.entity.objetMobile.personnage.deplacements.DeplacementBFS;
import com.example.zeldalike.modele.entity.objetMobile.personnage.deplacements.DeplacementLigneDroite;

public class BusinessMan extends Mob {

    public BusinessMan(Position position) {
        super(position, 1, 40, 3, null, new DeplacementAleatoireBFS());
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
