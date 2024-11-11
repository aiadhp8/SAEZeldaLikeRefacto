package com.example.zeldalike.modele.entity.objetImmobile.objetRecuperable;

import com.example.zeldalike.modele.entity.Position;
import com.example.zeldalike.modele.entity.objetImmobile.ObjetImmobile;

public abstract class ObjetRecuperables extends ObjetImmobile {
    private static int id = 0;
    private final String idObjRecup;

    public ObjetRecuperables(Position position){
        super(position);
        this.idObjRecup = "E" + id;
        id++;
    }

    public String getIdObjet() {
        return idObjRecup;
    }
}
