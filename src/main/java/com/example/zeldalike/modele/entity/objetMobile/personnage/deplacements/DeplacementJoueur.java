package com.example.zeldalike.modele.entity.objetMobile.personnage.deplacements;

import com.example.zeldalike.modele.entity.Position;

public class DeplacementJoueur implements StrategieDeplacements{
    @Override
    public int nouvelleDirection(int direction, Position p) {
        return 5;
    }
}
