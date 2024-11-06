package com.example.zeldalike.modele.entity.objetImmobile.objetRecuperable.potion;

import com.example.zeldalike.modele.entity.Position;
import com.example.zeldalike.modele.entity.objetImmobile.objetRecuperable.ObjetRecuperables;

public abstract class Potion extends ObjetRecuperables {
    private int valeurpouvoir;

    public Potion(Position position, int valeurpouvoir){
        super(position);
        this.valeurpouvoir = valeurpouvoir;
    }
}
