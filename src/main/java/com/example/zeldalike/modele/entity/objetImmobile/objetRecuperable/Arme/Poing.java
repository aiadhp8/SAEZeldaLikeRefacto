package com.example.zeldalike.modele.entity.objetImmobile.objetRecuperable.arme;

import com.example.zeldalike.modele.Joueur;
import com.example.zeldalike.modele.Personnage;
import com.example.zeldalike.modele.entity.objetImmobile.objetRecuperable.arme.Arme;

import java.util.ArrayList;

public class Poing extends Arme {
    public Poing(Joueur joueur) {
        super(30, joueur);
    }


    @Override
    public void faireUneAttaque() {
        ArrayList<Personnage> ennemisProche = this.toucherPersonnage();
        for (Personnage personnage : ennemisProche) {
            hit(personnage);
        }
    }

    @Override
    public String toString() {
        return super.toString() + "Poing";
    }
}
