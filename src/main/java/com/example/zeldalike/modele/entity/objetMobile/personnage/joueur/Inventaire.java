package com.example.zeldalike.modele.entity.objetMobile.personnage.joueur;

import com.example.zeldalike.modele.entity.objetImmobile.objetRecuperable.ObjetRecuperables;
import com.example.zeldalike.modele.entity.objetImmobile.objetRecuperable.Arme.Arme;

import java.util.ArrayList;
import java.util.HashMap;

public class Inventaire {

    private ObjetRecuperables armeEnMain;
    private ArrayList<ObjetRecuperables> articles;

    public Inventaire(ObjetRecuperables armeEnMain) {
        this.armeEnMain = armeEnMain;
        this.articles = new ArrayList<>();
    }

    public Arme getArmeEnMain() {
        return (Arme) armeEnMain;
    }

    public ArrayList<ObjetRecuperables> getArticles() {
        return articles;
    }

    public void ajoutInventaire(ObjetRecuperables obj) {
        obj.getPosition().setX(0);
        obj.getPosition().setY(0);
        this.articles.add(obj);
    }

    public void retireInventaire(ObjetRecuperables obj) {
        this.articles.remove(obj);
    }

    public void changerArmeEnMain(int num) {
        if (num >= 0 && num < this.articles.size() && this.articles.get(num) instanceof Arme) {
            ObjetRecuperables ancienneArme = this.armeEnMain;
            this.armeEnMain = this.articles.get(num);
            this.articles.set(num, ancienneArme);
        }
    }

    public ArrayList<ObjetRecuperables> getListeObjetDeType(Class<?> type) {
        ArrayList<ObjetRecuperables> liste = new ArrayList<>();
        for (ObjetRecuperables obj : this.articles) {
            if (type.isInstance(obj)) {
                liste.add(obj);
            }
        }
        return liste;
    }

    public int getQuantiteObjetDeType(Class<?> type) {
        return getListeObjetDeType(type).size();
    }

    public ObjetRecuperables getUnObjetDeType(Class<?> type) {
        for (ObjetRecuperables obj : this.articles) {
            if (type.isInstance(obj)) {
                return obj;
            }
        }
        return null;
    }

    public HashMap<String, Integer> getQuantiteTout() {
        HashMap<String, Integer> quantites = new HashMap<>();
        int quantitePotion = getQuantiteObjetDeType(PotionVitale.class);
        int quantiteCle = getQuantiteObjetDeType(Cle.class);
        int quantiteMunition = getQuantiteObjetDeType(Munition.class);

        if (quantitePotion > 0) quantites.put("PotionVitale", quantitePotion);
        if (quantiteCle > 0) quantites.put("Cle", quantiteCle);
        if (quantiteMunition > 0) quantites.put("Munition", quantiteMunition);

        return quantites;
    }

    public void utiliserPotion() {
        ObjetRecuperables potion = getUnObjetDeType(PotionVitale.class);
        if (potion instanceof PotionVitale) {
            this.j.recevoirSoins(((PotionVitale) potion).getPouvoir());
            this.retireInventaire(potion);
        }
    }
}
