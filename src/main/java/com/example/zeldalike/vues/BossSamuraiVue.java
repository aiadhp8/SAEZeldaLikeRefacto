package com.example.zeldalike.vues;


import com.example.zeldalike.modele.entity.objetMobile.personnage.ennemi.Ennemis;
import javafx.scene.image.ImageView;

public class BossSamuraiVue extends EnnemisVue {
    private ImageView lame;
    private ImageView chapeau;

    public BossSamuraiVue(Ennemis ennemis, String file) {
        super(ennemis, file);
    }


}
