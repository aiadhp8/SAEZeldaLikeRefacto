package com.example.zeldalike.vues;

import com.example.zeldalike.modele.entity.objetMobile.personnage.ennemi.Ennemis;
import com.example.zeldalike.modele.entity.objetMobile.projectile.Projectile;
import javafx.scene.image.ImageView;

public class ProjectileVue {
    private final Projectile projo;
    private final String file;
    private final ImageView i;

    public ProjectileVue(Projectile projo, String file) {
        this.projo = projo;
        this.file = file;
        this.i = new ImageView(file);
        i.translateXProperty().bind(projo.getPosition().xProperty());
        i.translateYProperty().bind(projo.getPosition().yProperty());
    }

    public ImageView getI() {
        return i;
    }

    public Projectile getProjo() {
        return this.projo;
    }
}
