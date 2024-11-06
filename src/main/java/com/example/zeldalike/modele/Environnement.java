package com.example.zeldalike.modele;

import com.example.zeldalike.modele.entity.objetImmobile.objetRecuperable.ObjetRecuperables;
import com.example.zeldalike.modele.entity.objetMobile.personnage.joueur.Joueur;
import com.example.zeldalike.modele.entity.objetMobile.personnage.ennemi.Ennemis;
import com.example.zeldalike.modele.entity.objetMobile.projectile.ProjectileMunition;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

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

    public Environnement(int height, int width) {
        this.height = height;
        this.width = width;
        this.terrain = new Terrain();
        this.carteBFS = new CarteBFS(this.terrain, this.joueur);
        this.joueur =;
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

    public void sortirObjet(ObjetRecuperables objet) {
        this.objet.remove(objet);
    }

    public ObservableList<ObjetRecuperables> getObjet() {
        return objet;
    }

    public ObservableList<ProjectileMunition> getProjoMunition() {
        return projoMunition;
    }

    public void updateProjectiles() {

        Iterator<Munition> iterator = this.munitionObservableList.iterator();
        while (iterator.hasNext()) {
            Munition munition = iterator.next();
            munition.move();


            boolean removed = false;
            for (Ennemis ennemi : this.getEnv().getEnnemis()) {
                if (munition.collidesWith(ennemi)) {
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
        munitionObservableList.removeIf(munition -> !this.getTerrain().estDansTerrain(munition.getP().getX(), munition.getP().getY()));
    }

    public void unTour() {
        this.joueur.move();
        this.carteBFS.miseAJourCarte();
        this.getJ1().interact();
        this.getJ1().updateProjectiles();

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
        verifierCollisions();
        compteur++;
        cooldown++;

    }
}
