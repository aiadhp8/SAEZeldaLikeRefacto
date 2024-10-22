package com.example.zeldalike.modele.entity.objetMobile.personnage;

import com.example.zeldalike.modele.entity.Position;
import com.example.zeldalike.modele.entity.objetMobile.ObjetMobile;

public abstract class Personnage extends ObjetMobile {
    
    private int hp;
    
    public Personnage(Position position, int direction, int vitesse, int hp) {
        super(position, direction, vitesse);
        this.hp = hp;
    }
    
}
