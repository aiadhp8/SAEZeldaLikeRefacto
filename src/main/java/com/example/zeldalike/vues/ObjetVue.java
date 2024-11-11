package com.example.zeldalike.vues;

import com.example.zeldalike.modele.entity.objetImmobile.objetRecuperable.ObjetRecuperables;
import javafx.scene.image.ImageView;

public class ObjetVue {
    private ObjetRecuperables objetRecuperables;
    private String file;
    private ImageView i;

    public ObjetVue(ObjetRecuperables objetRecuperables, String file) {
        this.objetRecuperables = objetRecuperables;
        this.file = file;
        this.i = new ImageView(file);
        i.setId(objetRecuperables.getIdObjet());
        i.translateXProperty().bind(objetRecuperables.getPosition().xProperty());
        i.translateYProperty().bind(objetRecuperables.getPosition().yProperty());

    }

    public ImageView getI() {
        return i;
    }
}
