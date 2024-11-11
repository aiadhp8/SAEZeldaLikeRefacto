package com.example.zeldalike.modele.entity.objetImmobile.objetRecuperable.arme.gun;


import com.example.zeldalike.modele.Environnement;
import com.example.zeldalike.modele.entity.Position;
import com.example.zeldalike.modele.entity.objetImmobile.objetRecuperable.arme.Arme;
import com.example.zeldalike.modele.entity.objetMobile.personnage.joueur.Joueur;
import com.example.zeldalike.modele.entity.objetMobile.projectile.ProjectileMunition;

import java.util.ArrayList;

public class Gun extends Arme {

    public Gun() {
        super(new Position(0,0,0,0), 50);
    }

   /* public boolean aMuni(){
        return munitions > 0;
    }

    public void retirerMuni(){
        if (aMuni()){
            munitions--;
        }
    }

    public int getMunitions(){
        return munitions;
    }

    public void setMunitions(int munitions){
        this.munitions = munitions;
    }
*/

    @Override
    public void faireUneAttaque() {
        if (Environnement.getInstance().getJoueur().getInventaire().getQuantiteObjetDeType(Munition.class) > 0) {

            Joueur joueur = Environnement.getInstance().getJoueur();
            ProjectileMunition projo = new ProjectileMunition(new Position(joueur.getPosition().getX(), joueur.getPosition().getY(), 32, 32), joueur.getDirection());
            Environnement.getInstance().getProjoMunition().add(projo);

            Munition mune = (Munition) Environnement.getInstance().getJoueur().getInventaire().getUnObjetDeType(Munition.class);
            Environnement.getInstance().getJoueur().getInventaire().retireInventaire(mune);

        } else {
            System.out.println("tu n'as aucune balle");
        }
    }

    @Override
    public String toString() {
        return super.toString() + "GUN";
    }
}
