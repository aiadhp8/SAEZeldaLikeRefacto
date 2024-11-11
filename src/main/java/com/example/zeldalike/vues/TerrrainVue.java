package com.example.zeldalike.vues;

import com.example.zeldalike.Main;

import com.example.zeldalike.modele.Environnement;
import com.example.zeldalike.modele.Terrain;
import com.example.zeldalike.modele.entity.objetMobile.personnage.joueur.Joueur;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.TilePane;

import java.util.Random;

public class TerrrainVue {
    private final TilePane affichage;
    private final Pane affichageElement;
    private final Terrain terrrain;

    public TerrrainVue(TilePane affichage, Pane affichageElement, Terrain terrrain) {
        this.affichage = affichage;
        this.affichageElement = affichageElement;
        this.terrrain = terrrain;

        final int zoneTemp = 32;
        final int decalageX = 2048;
        final int decalageY = 1224;

        Environnement.getInstance().getJoueur().getPosition().xProperty().addListener((obs, old, n) -> {
            if ((int) n % decalageX > decalageX - zoneTemp) {
                affichageElement.setTranslateX(affichageElement.getTranslateX() - decalageX);
                Environnement.getInstance().getJoueur().getPosition().setX(Environnement.getInstance().getJoueur().getPosition().getX() + 2 * zoneTemp);
            } else if ((int) n > decalageX && (int) n % decalageX < zoneTemp) {
                affichageElement.setTranslateX(affichageElement.getTranslateX() + decalageX);
                Environnement.getInstance().getJoueur().getPosition().setX(Environnement.getInstance().getJoueur().getPosition().getX() - 2 * zoneTemp);
            }
        });
        Environnement.getInstance().getJoueur().getPosition().yProperty().addListener((obs, old, n) -> {
            if ((int) n % decalageY > decalageY - zoneTemp) {
                affichageElement.setTranslateY(affichageElement.getTranslateY() - decalageY);
                Environnement.getInstance().getJoueur().getPosition().setY(Environnement.getInstance().getJoueur().getPosition().getY() + 2 * zoneTemp);
            } else if ((int) n > decalageY && (int) n % decalageY < zoneTemp) {
                affichageElement.setTranslateY(affichageElement.getTranslateY() + decalageY);
                Environnement.getInstance().getJoueur().getPosition().setY(Environnement.getInstance().getJoueur().getPosition().getY() - 2 * zoneTemp);
            }
        });
        Environnement.getInstance().getJoueur().hpProperty().addListener((obs, old, n) -> {
            if (Environnement.getInstance().getJoueur().getHp() == 0) {
                affichageElement.setTranslateX(0);
                affichageElement.setTranslateY(0);
            }
        });
    }

    public void creeMap() {


        Image eau = new Image(String.valueOf(Main.class.getResource("images/terrain/eau2.png")));
        Image trou = new Image(String.valueOf(Main.class.getResource("images/terrain/trou2.png")));
        Image terre = new Image(String.valueOf(Main.class.getResource("images/terrain/terre2.png")));
        Image eau2 = new Image(String.valueOf(Main.class.getResource("images/terrain/eau3.png")));
        Image terre2 = new Image(String.valueOf(Main.class.getResource("images/terrain/terre3.png")));
        Random random = new Random(67890);
        this.affichage.setPrefColumns(this.terrrain.getTailleLargeur());
        int diftuiles;
        for (int i = 0; i < this.terrrain.getTailleTerrain(); i++) {
            diftuiles = random.nextInt();
            switch (this.terrrain.codeCaseI(i)) {
                case 1:
                    if (diftuiles < 4096) {
                        affichage.getChildren().add(new ImageView(eau));
                    } else {
                        affichage.getChildren().add(new ImageView(eau2));
                    }
                    break;

                case 2:
                    if (diftuiles < 4096) {
                        affichage.getChildren().add(new ImageView(terre));
                    } else {
                        affichage.getChildren().add(new ImageView(terre2));
                    }
                    break;

                case 3:
                    affichage.getChildren().add(new ImageView(trou));
                    break;
            }
        }

    }

}

