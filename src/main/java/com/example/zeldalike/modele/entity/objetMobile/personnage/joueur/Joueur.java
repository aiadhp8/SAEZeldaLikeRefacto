package com.example.zeldalike.modele.entity.objetMobile.personnage.joueur;

import com.example.zeldalike.modele.entity.Position;
import com.example.zeldalike.modele.entity.objetMobile.personnage.Personnage;

import java.util.ArrayList;

public class Joueur extends Personnage {

    private boolean interaction;
    private boolean hydrophobe;

    private Inventaire inventaire;

    public Joueur(Position position, int vitesse, int hp, Inventaire inventaire) {
        super(position, vitesse, hp);
        this.inventaire = inventaire;
        this.interaction = false;
        this.hydrophobe = false;
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
        for (Personnage ennemi : this.getEnv().getEnnemis()) {
            if (ennemi.enVie() && distanceEntreDeuxPersonnages(this, ennemi) < 50) {
                ennemisProches.add(ennemi);
            }
        }
        return ennemisProches;
    }

    public void interact() {
        ObjetRecuperables objet = null;
        if (this.interaction) {
            for (ObjetRecuperables o : this.getEnv().getObjet()) {
                if (this.getP().collisionEntreSprites(o.getP()) || this.getP().surSprites(o.getP())) {
                    objet = o;
                    break;
                }
            }
            if (objet != null) {
                if (objet instanceof PotionVitale || objet instanceof Cle) {
                    this.getSac().ajoutInventaire(objet);

                } else if (objet instanceof ChaussuresHydrophobes) {
                    this.getSac().ajoutInventaire(objet);
                    hydrophobe = true;
                } else if (objet instanceof Munition) {
                    this.getSac().ajoutInventaire(objet);
                    this.donnerMunition();
                    System.out.println("Munition ramassée et ajoutée au sac : " + objet);
                }
                this.getEnv().sortirObjet(objet);
            }
            interaction = false;
        }

}
