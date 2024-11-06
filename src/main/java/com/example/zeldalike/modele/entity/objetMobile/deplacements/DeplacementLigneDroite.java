package com.example.zeldalike.modele.entity.objetMobile.deplacements;

import com.example.zeldalike.modele.entity.Position;

public class DeplacementLigneDroite implements StrategieDeplacements{

    @Override
    public int nouvelleDirection(int direction, Position p) {
        return direction;
    }
}
