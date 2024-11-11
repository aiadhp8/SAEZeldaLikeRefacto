package com.example.zeldalike.modele.entity.objetImmobile.objetRecuperable.arme;


import com.example.zeldalike.modele.Environnement;
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
        ArrayList<Personnage> ennemisProches = Environnement.getInstance().getJoueur().getEnnemisProches();
        ArrayList<Personnage> ennemisToucher = new ArrayList<Personnage>();
        for (Personnage ennemi : ennemisProches) {
            System.out.println(ennemi);
            if (ennemi != null) {
                if (this.collision(ennemi)) {
                    ennemisToucher.add(ennemi);
                }
            }
        }
        System.out.println(ennemisToucher.toString());
        return ennemisToucher;
    }


}
