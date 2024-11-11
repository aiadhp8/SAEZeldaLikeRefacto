package com.example.zeldalike.controlleurs;

import com.example.zeldalike.Main;
import com.example.zeldalike.modele.entity.objetMobile.personnage.ennemi.Ennemis;
import com.example.zeldalike.modele.entity.objetMobile.projectile.Projectile;
import com.example.zeldalike.modele.entity.objetMobile.projectile.ProjectileBoss;
import com.example.zeldalike.modele.entity.objetMobile.projectile.ProjectileMunition;
import com.example.zeldalike.vues.EnnemisVue;
import com.example.zeldalike.vues.ProjectileVue;
import javafx.collections.ListChangeListener;
import javafx.scene.layout.Pane;

public class MonObservateurProjectile implements ListChangeListener<Projectile> {
    private final Pane panneauDeJeu;
    private ProjectileVue projoVue;

    public MonObservateurProjectile(Pane panneauDeJeu) {
        this.panneauDeJeu = panneauDeJeu;
        this.projoVue = null;
    }

    @Override
    public void onChanged(Change<? extends Projectile> change) {
        while (change.next()) {
            for (Projectile e : change.getAddedSubList()) {
                if (e instanceof ProjectileBoss) {
                    projoVue = new ProjectileVue(e, String.valueOf(Main.class.getResource("images/blade-2.png")));
                } else if (e instanceof ProjectileMunition) {
                    projoVue = new ProjectileVue(e, String.valueOf(Main.class.getResource("images/gressif_gun/munitionBas.png")));
                }


                this.panneauDeJeu.getChildren().add(projoVue.getI());


            }
            for (Projectile mort : change.getRemoved()) {
                this.panneauDeJeu.getChildren().remove(this.panneauDeJeu.lookup("#" + mort.getIdProjo()));
            }
        }
    }
}
