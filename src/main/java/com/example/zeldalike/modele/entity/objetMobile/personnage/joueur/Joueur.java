package com.example.zeldalike.modele.entity.objetMobile.personnage.joueur;

import com.example.zeldalike.modele.Environnement;
import com.example.zeldalike.modele.entity.Position;
import com.example.zeldalike.modele.entity.objetImmobile.objetRecuperable.ChaussuresHydrophobes;
import com.example.zeldalike.modele.entity.objetImmobile.objetRecuperable.Clef;
import com.example.zeldalike.modele.entity.objetImmobile.objetRecuperable.ObjetRecuperables;
import com.example.zeldalike.modele.entity.objetImmobile.objetRecuperable.arme.Arme;
import com.example.zeldalike.modele.entity.objetImmobile.objetRecuperable.arme.gun.Munition;
import com.example.zeldalike.modele.entity.objetImmobile.objetRecuperable.potion.PotionVitale;
import com.example.zeldalike.modele.entity.objetMobile.personnage.Personnage;

import java.util.ArrayList;

public class Joueur extends Personnage {

    private Inventaire inventaire;

    private boolean interaction;
    private boolean hydrophobe;
    private boolean subirCoup;


    public Joueur(Position position, int vitesse, int hp, Inventaire inventaire) {
        super(position, vitesse, hp);
        this.inventaire = inventaire;
        this.interaction = false;
        this.hydrophobe = false;
    }

    public boolean peutSubirCoup() {
        return subirCoup;
    }

    public void setSubirCoup(boolean b){
        subirCoup = b;
    }

    @Override
    public void subirDegats(int degats) {
        this.setHp(this.getHp() - degats);
    }

    @Override
    public void recevoirSoins(int pv) {
        setHp(Math.min(12, getHp() + pv));
    }

    public void setInteraction(boolean interaction) {
        this.interaction = interaction;
    }

    public Arme getArme() {
        return inventaire.getArmeEnMain();
    }

    public void attaquer() {
        this.getArme().faireUneAttaque();
    }

    public ArrayList<Personnage> getEnnemisProches() {
        ArrayList<Personnage> ennemisProches = new ArrayList<>();
        for (Personnage ennemi : Environnement.getInstance().getEnnemis()) {
            if (ennemi.enVie() && this.distance(ennemi) < 50) {
                ennemisProches.add(ennemi);
            }
        }
        return ennemisProches;
    }

    public void interact() {
        ObjetRecuperables objet = null;
        if (this.interaction) {
            for (ObjetRecuperables o : Environnement.getInstance().getObjets()) {
                if (this.collision(o)) {
                    objet = o;
                    break;
                }
            }
            if (objet != null) {
                if (objet instanceof PotionVitale || objet instanceof Clef) {
                    this.inventaire.ajoutInventaire(objet);

                } else if (objet instanceof ChaussuresHydrophobes) {
                    this.inventaire.ajoutInventaire(objet);
                    hydrophobe = true;

                } else if (objet instanceof Munition) {
                    this.inventaire.ajoutInventaire(objet);
                    this.donnerMunition();
                    System.out.println("Munition ramassée et ajoutée au sac : " + objet);
                }
                Environnement.getInstance().sortirObjet(objet);
            }
            interaction = false;
        }

    }
}
