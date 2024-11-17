package com.example.zeldalike.controlleurs;

import com.example.zeldalike.Main;
import com.example.zeldalike.modele.entity.objetImmobile.Citron;
import com.example.zeldalike.modele.entity.objetMobile.personnage.ennemi.Ennemis;
import com.example.zeldalike.modele.entity.objetMobile.personnage.ennemi.boss.Boss;
import com.example.zeldalike.modele.entity.objetMobile.personnage.ennemi.mob.BusinessMan;
import com.example.zeldalike.modele.entity.objetMobile.personnage.ennemi.mob.Macarena;
import com.example.zeldalike.modele.entity.objetMobile.projectile.ProjectileBoss;
import com.example.zeldalike.vues.BossSamuraiVue;
import com.example.zeldalike.vues.EnnemisVue;
import javafx.collections.ListChangeListener;
import javafx.scene.layout.Pane;

public class MonObservateurEnnemis implements ListChangeListener<Ennemis> {
    private final Pane panneauDeJeu;
    private EnnemisVue ennemisVue;

    public MonObservateurEnnemis(Pane panneauDeJeu) {
        this.panneauDeJeu = panneauDeJeu;
        this.ennemisVue = null;
    }


    @Override
    public void onChanged(Change<? extends Ennemis> change) {
        while (change.next()) {
            for (Ennemis e : change.getAddedSubList()) {
                if (e instanceof BusinessMan) {
                    ennemisVue = new EnnemisVue(e, String.valueOf(Main.class.getResource("images/ennemis/businessman2.png")));
                } else if (e instanceof Boss) {
                    ennemisVue = new BossSamuraiVue(e, String.valueOf(Main.class.getResource("images/ennemis/bosstemp.png")));
                } else if (e instanceof Macarena) {
                    ennemisVue = new EnnemisVue(e, String.valueOf(Main.class.getResource("images/ennemis/macarena.gif")));
                }


                this.panneauDeJeu.getChildren().add(ennemisVue.getI());


            }
            for (Ennemis mort : change.getRemoved()) {
                System.out.println(this.panneauDeJeu.getChildren().remove(this.panneauDeJeu.lookup("#" + mort.getIdEnnemi())));
                System.out.println("personnage enlevé");
            }
        }
    }
}
