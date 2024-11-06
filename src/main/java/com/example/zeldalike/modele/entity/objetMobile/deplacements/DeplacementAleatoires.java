package com.example.zeldalike.modele.entity.objetMobile.deplacements;

import com.example.zeldalike.modele.entity.Position;

import java.util.Random;

public class DeplacementAleatoires implements StrategieDeplacements{

    public DeplacementAleatoires(){
    }

    @Override
    public int nouvelleDirection(int direction, Position p) {
        Random quelleDirection = new Random();
        int nouvelledirection = direction;
        int t = quelleDirection.nextInt(500);
        if (t < 50) {
            t = quelleDirection.nextInt(400);
            if (t < 100) {
                nouvelledirection = 8;
            } else if (t < 200) {
                nouvelledirection = 4;
            } else if (t < 300) {
                nouvelledirection = 2;
            } else {
                nouvelledirection = 6;
            }

        }
        return nouvelledirection;
    }
}
