package com.example.zeldalike.vues;


import com.example.zeldalike.modele.entity.objetMobile.personnage.ennemi.Ennemis;
import javafx.scene.image.ImageView;

public class EnnemisVue {
    private final Ennemis ennemis;
    private final String file;
    private final ImageView i;

    public EnnemisVue(Ennemis ennemis, String file) {
        this.ennemis = ennemis;
        this.file = file;
        this.i = new ImageView(file);
        i.translateXProperty().bind(ennemis.getPosition().xProperty());
        i.translateYProperty().bind(ennemis.getPosition().yProperty());


    }

    public ImageView getI() {
        return i;
    }

    public Ennemis getEnnemis() {
        return this.ennemis;
    }
}
