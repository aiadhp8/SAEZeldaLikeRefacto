package com.example.zeldalike.vues;

import com.example.zeldalike.modele.entity.objetImmobile.objetRecuperable.arme.gun.Munition;
import com.example.zeldalike.modele.entity.objetMobile.projectile.ProjectileMunition;
import javafx.scene.image.ImageView;

public class MunitionVue {
    private Munition munition;
    private String file;
    private ImageView image;

    public MunitionVue(Munition munition, String file) {
        this.munition = munition;
        this.file = file;
        this.image = new ImageView(file);
        image.setId(munition.getIdObjet());
        image.translateXProperty().bind(munition.getPosition().xProperty());
        image.translateYProperty().bind(munition.getPosition().yProperty());
    }

    public ImageView getImage() {
        return image;
    }
}
