package com.example.zeldalike.modele.entity.objetMobile.personnage.joueur;

import com.example.zeldalike.modele.entity.Position;
import com.example.zeldalike.modele.entity.objetMobile.personnage.Personnage;
import com.example.zeldalike.modele.entity.objetMobile.personnage.joueur.inventaire.Inventaire;

public class Joueur extends Personnage {

    private Inventaire inventaire;

    public Joueur(Position position, int vitesse, int hp, Inventaire inventaire) {
        super(position, vitesse, hp);
        this.inventaire = inventaire;
    }

    @Override
    public void subirDegats(int degats) {
        this.setHp(this.getHp() - degats);
    }

    @Override
    public void recevoirSoins(int pv) {
        setHp(Math.min(12, getHp() + pv));
    }
}
