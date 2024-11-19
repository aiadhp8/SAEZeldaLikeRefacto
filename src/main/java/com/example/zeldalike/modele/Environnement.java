package com.example.zeldalike.modele;

import com.example.zeldalike.modele.entity.Position;
import com.example.zeldalike.modele.entity.objetImmobile.objetRecuperable.ObjetRecuperables;
import com.example.zeldalike.modele.entity.objetImmobile.objetRecuperable.arme.Poing;
import com.example.zeldalike.modele.entity.objetImmobile.objetRecuperable.arme.gun.Gun;
import com.example.zeldalike.modele.entity.objetImmobile.objetRecuperable.arme.gun.Munition;
import com.example.zeldalike.modele.entity.objetMobile.personnage.Personnage;
import com.example.zeldalike.modele.entity.objetMobile.personnage.joueur.Inventaire;
import com.example.zeldalike.modele.entity.objetMobile.personnage.joueur.Joueur;
import com.example.zeldalike.modele.entity.objetMobile.personnage.ennemi.Ennemis;
import com.example.zeldalike.modele.entity.objetMobile.projectile.ProjectileMunition;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.junit.Ignore;

import java.util.Iterator;

public class Environnement {

    private static Environnement instance;

    private int height;
    private int width;

    private Terrain terrain;
    private CarteBFS carteBFS;

    private Joueur joueur;
    private ObservableList<Ennemis> ennemis;
    private ObservableList<ObjetRecuperables> objet;
    private ObservableList<ProjectileMunition> projoMunition;

    private int compteur;

    private Environnement(int height, int width) {
        this.height = height;
        this.width = width;
        terrain = new Terrain();
        this.terrain = terrain;
        this.carteBFS = new CarteBFS(terrain);
        this.joueur = new Joueur(new Position(96,65,32,32), 6,4,new Inventaire(new Poing(new Position(0,0,32,32))));
        //this.joueur = new Joueur(new Position(300,300,32,32), 6,4,new Inventaire(new Poing(new Position(0,0,32,32))));
        Gun gun = new Gun();
        joueur.getInventaire().ajoutInventaire(gun);
        this.ennemis = FXCollections.observableArrayList();
        this.objet = FXCollections.observableArrayList();
        this.projoMunition = FXCollections.observableArrayList();
        this.compteur = 0;
    }

    public static Environnement getInstance() {
        if (instance == null) {
            instance = new Environnement(2048, 4096);
        }
        return instance;
    }

    public Terrain getTerrain(){
        return this.terrain;
    }

    public Joueur getJoueur() {
        return this.joueur;
    }

    public void ajouterEnnemis(Ennemis ennemis) {
        this.ennemis.add(ennemis);
    }

    public void sortirEnnemis(Ennemis ennemis) {
        this.ennemis.remove(ennemis);
    }

    public ObservableList<Ennemis> getEnnemis() {
        return ennemis;
    }

    public void ajouterObjet(ObjetRecuperables objet) {
        this.objet.add(objet);
    }

    public CarteBFS getCarteBFS(){
        return this.carteBFS;
    }

    public void sortirObjet(ObjetRecuperables objet) {
        this.objet.remove(objet);
    }

    public ObservableList<ObjetRecuperables> getObjets() {
        return objet;
    }

    public ObservableList<ProjectileMunition> getProjoMunition() {
        return projoMunition;
    }

    public void updateProjectiles() {

        Iterator<ProjectileMunition> iterator = this.projoMunition.iterator();
        while (iterator.hasNext()) {
            ProjectileMunition munition = iterator.next();
            munition.move();


            boolean removed = false;
            for (Ennemis ennemi : instance.getEnnemis()) {
                if (munition.collision(ennemi)) {
                    ennemi.subirDegats(munition.getDegats());

                    iterator.remove(); // Utilisez l'iterator pour éviter ConcurrentModificationException
                    removed = true;
                    break; // Sortir de la boucle des ennemis, car la munition a été supprimée
                }
            }
            if (removed) {
                continue; // Si la munition a été supprimée, passez à la suivante
            }

        }
        // Supprimer les projectiles qui sortent du terrain
        projoMunition.removeIf(munition -> !this.getTerrain().estDansTerrain(munition.getPosition().getX(), munition.getPosition().getY()));
    }

    public void unTour() {
        this.joueur.move();
        this.carteBFS.miseAJourCarte();
        this.joueur.interact();
        this.updateProjectiles();

        if (!ennemis.isEmpty()) {
            for (int i = 0; i < ennemis.size(); i++) {
                ennemis.get(i).agir();
                ennemis.get(i).compétence();
                if (!ennemis.get(i).enVie()) {
                    ennemis.get(i).désacCompétence();
                    ennemis.get(i).dropObjet();
                    sortirEnnemis(ennemis.get(i));
                }
            }
        }
        collisionMob();
        compteur++;
    }

    public void collisionMob() {

        for (Ennemis ennemi : ennemis) {
            if (compteur % 150 == 0) {
                joueur.setSubirCoup(true);
            }
            if (ennemi.collision(joueur)) {
                Personnage.repousserPersonnages(joueur, ennemi);
                if (joueur.peutSubirCoup()) {
                    joueur.subirDegats(1);
                    joueur.setSubirCoup(false);
                }
            }
        }
    }
}
