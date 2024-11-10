package com.example.zeldalike.modele.entity.objetImmobile.objetRecuperable.arme;


import com.example.zeldalike.modele.entity.Position;
import com.example.zeldalike.modele.entity.objetImmobile.objetRecuperable.ObjetRecuperables;
import com.example.zeldalike.modele.entity.objetMobile.personnage.Personnage;
import com.example.zeldalike.modele.entity.objetMobile.personnage.ennemi.Ennemis;

import java.util.ArrayList;


public abstract class Arme extends ObjetRecuperables {

    private final int attaque;

    public Arme(Position position, int attaque) {
        super(position);
        this.attaque = attaque;
    }

    public void hit(Ennemis e) {
        if (!e.isBouclierActif())
            e.subirDegats(Math.max(attaque - e.getDef(), 0));
    }

    public abstract void faireUneAttaque();

    public ArrayList<Personnage> toucherPersonnage() {
        ArrayList<Personnage> ennemisProches = this.joueur.getEnnemisProches();
        ArrayList<Personnage> ennemisToucher = new ArrayList<Personnage>();
        for (Personnage ennemi : ennemisProches) {
            System.out.println(ennemi);
            if (ennemi != null) {
                this.directionPersonnage();
                if (this.collision(ennemi)) {
                    System.out.println(" la");
                    System.out.println(this.p.toString());
                    System.out.println(this.joueur.getP().toString());
                    ennemisToucher.add(ennemi);
                }
            }
        }
        System.out.println(ennemisToucher.toString());
        return ennemisToucher;
    }
}
