package com.example.zeldalike.modele.entity.objetImmobile.objetRecuperable.arme;


import com.example.zeldalike.modele.entity.Position;
import com.example.zeldalike.modele.entity.objetImmobile.objetRecuperable.arme.Arme;
import com.example.zeldalike.modele.entity.objetMobile.personnage.Personnage;
import com.example.zeldalike.modele.entity.objetMobile.personnage.ennemi.Ennemis;
import com.example.zeldalike.modele.entity.objetMobile.personnage.joueur.Joueur;

import java.util.ArrayList;

public class Poing extends Arme {
    public Poing(Position position) {
        super(position, 20);
    }


    @Override
    public void faireUneAttaque() {
        ArrayList<Personnage> ennemisProche = this.toucherPersonnage();
        for (Personnage personnage : ennemisProche) {
            hit((Ennemis) personnage);
        }
    }

    @Override
    public String toString() {
        return super.toString() + "Poing";
    }
}
