package com.example.zeldalike.vues;

import com.example.zeldalike.modele.entity.objetMobile.projectile.ProjectileMunition;
import javafx.scene.image.ImageView;

public class MunitionVue {
    private ProjectileMunition munition;
    private String file;
    private ImageView image;

    public MunitionVue(ProjectileMunition munition, String file) {
        this.munition = munition;
        this.file = file;
        this.image = new ImageView(file);
        image.setId(munition.getIdObjet());
        image.translateXProperty().bind(munition.getP().xProperty());
        image.translateYProperty().bind(munition.getP().yProperty());
    }

    public ImageView getImage() {
        return image;
    }
}
