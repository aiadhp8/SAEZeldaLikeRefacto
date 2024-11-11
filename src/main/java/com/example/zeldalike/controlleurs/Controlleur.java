package com.example.zeldalike.controlleurs;

import com.example.zeldalike.modele.*;
import com.example.zeldalike.modele.entity.Position;
import com.example.zeldalike.modele.entity.objetImmobile.objetRecuperable.ChaussuresHydrophobes;
import com.example.zeldalike.modele.entity.objetImmobile.objetRecuperable.arme.Poing;
import com.example.zeldalike.modele.entity.objetImmobile.objetRecuperable.arme.gun.Gun;
import com.example.zeldalike.modele.entity.objetImmobile.objetRecuperable.arme.gun.Munition;
import com.example.zeldalike.modele.entity.objetImmobile.objetRecuperable.potion.PotionVitale;
import com.example.zeldalike.modele.entity.objetMobile.personnage.ennemi.boss.Boss;
import com.example.zeldalike.modele.entity.objetMobile.personnage.ennemi.boss.BossSamurai;
import com.example.zeldalike.modele.entity.objetMobile.personnage.ennemi.mob.*;
import com.example.zeldalike.vues.InventaireVue;
import com.example.zeldalike.vues.JoueurVue;
import com.example.zeldalike.vues.TerrrainVue;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.TilePane;
import javafx.util.Duration;

import java.net.URL;
import java.util.HashSet;
import java.util.ResourceBundle;
import java.util.Set;

public class Controlleur implements Initializable {

    private final Set<String> pressedKeys = new HashSet<>();
    @FXML
    private HBox info_joueur;
    @FXML
    private HBox coeurBox;
    @FXML
    private Label nbArgent;
    @FXML
    private TilePane terrain_affichage;

    @FXML
    private TilePane inventairepane;
    @FXML
    private TilePane inventaireobjets;
    private InventaireVue inv;

    @FXML
    private Pane carte_interaction;
    private long lastTime;
    private JoueurVue joueurVue;
    private Timeline gameLoop;
    private int temps_gameloop;
    private boolean cooldown = true;
    private boolean inventaire_ouvert = false;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Environnement env = Environnement.getInstance();
        TerrrainVue terrrainVue = new TerrrainVue(terrain_affichage, carte_interaction, env.getTerrain());
        terrain_affichage.setOnKeyPressed(this::onKeyPressed);
        terrain_affichage.setOnKeyReleased(this::onKeyReleased);
        terrain_affichage.setFocusTraversable(true);
        terrrainVue.creeMap();
        joueurVue = new JoueurVue(env.getJoueur(), env.getJoueur().getArme());

        info_joueur.getChildren().add(joueurVue.getCoeurN1());
        info_joueur.getChildren().add(joueurVue.getCoeurN2());
        info_joueur.getChildren().add(joueurVue.getCoeurN3());

        carte_interaction.getChildren().add(joueurVue.getMac());
        carte_interaction.getChildren().add(joueurVue.getArmeView());


        env.getJoueur().directionProperty().addListener(((observable, oldValue, newValue) -> {
            if (env.getJoueur().getArme() instanceof Poing) {
                switch ((int) newValue) {
                    case 8:
                        this.joueurVue.getMac().setImage(this.joueurVue.getSpriteUp());
                        break;
                    case 2:
                        this.joueurVue.getMac().setImage(this.joueurVue.getSpriteDown());
                        break;
                    case 4:
                        this.joueurVue.getMac().setImage(this.joueurVue.getSpriteLeft());
                        break;
                    case 6:
                        this.joueurVue.getMac().setImage(this.joueurVue.getSpriteRight());
                        break;
                }
            } else if (env.getJoueur().getArme() instanceof Gun) {
                switch ((int) newValue) {
                    case 8:
                        this.joueurVue.getMac().setImage(this.joueurVue.getSpriteGunUp());
                        System.out.println();
                        break;
                    case 2:
                        this.joueurVue.getMac().setImage(this.joueurVue.getSpriteGunDown());
                        break;
                    case 4:
                        this.joueurVue.getMac().setImage(this.joueurVue.getSpriteGunLeft());
                        break;
                    case 6:
                        this.joueurVue.getMac().setImage(this.joueurVue.getSpriteGunRight());

                }
            }
        }));
        MonObservateurEnnemis observateurlisteennemi = new MonObservateurEnnemis(carte_interaction);
        MonObservateurProjectile observateurProjectile = new MonObservateurProjectile(carte_interaction);
        env.getEnnemis().addListener(observateurlisteennemi);
        env.getProjoMunition().addListener(observateurProjectile);
        Macarena maca = new Macarena(new Position(3175, 515, 32,32));
        env.ajouterEnnemis(maca);
        BusinessMan man1 = new BusinessMan(new Position(640, 640, 32,32));
        env.ajouterEnnemis(man1);
        BusinessMan man2 = new BusinessMan(new Position(3175, 560,32,32));
        env.ajouterEnnemis(man2);
        BusinessMan man3 = new BusinessMan(new Position(3000, 540, 32,32));
        env.ajouterEnnemis(man3);
        BusinessMan man4 = new BusinessMan(new Position(1179, 1722, 32,32));
        env.ajouterEnnemis(man4);
        BusinessMan man5 = new BusinessMan(new Position(759, 1692, 32,32));
        env.ajouterEnnemis(man5);
        Boss pumkin = new BossSamurai(new Position(192, 1888,32,64));
        env.ajouterEnnemis(pumkin);

        MonObservateurObjet observateurlisteobjet = new MonObservateurObjet(carte_interaction);
        env.getObjets().addListener(observateurlisteobjet);

        Munition p1 = new Munition(new Position(3775, 1345,32,32));
        Munition p2 = new Munition(new Position(400, 64,32,32));
        env.ajouterObjet(p1);
        env.ajouterObjet(p2);
        env.ajouterObjet(new PotionVitale(new Position(600, 455,32,32)));
        env.ajouterObjet(new PotionVitale(new Position(3640, 440,32,32)));
        env.ajouterObjet(new PotionVitale(new Position(256, 64,32,32)));
        env.ajouterObjet(new PotionVitale(new Position(3910, 1749,32,32)));
        env.ajouterObjet(new ChaussuresHydrophobes(new Position(2500, 1299,32,32)));

        //this.env.getJ1().getSac().ajoutInventaire(new PotionVitale(new Position(5, 5)));
        //this.env.getJ1().getSac().ajoutInventaire(new PotionVitale(new Position(5, 5)));
        //this.env.getJ1().getSac().ajoutInventaire(new Cle(new Position(0, 0)));
        this.inventairepane.setVisible(false);
        this.inv = new InventaireVue(inventairepane, inventaireobjets, env.getJoueur().getInventaire());


        terrain_affichage.requestFocus();

        initAnimation();
        gameLoop.play();
    }

    private void onKeyPressed(KeyEvent event) {
        pressedKeys.add(event.getCode().toString());
        handleMovement();
    }

    private void onKeyReleased(KeyEvent event) {
        pressedKeys.remove(event.getCode().toString());
        Environnement.getInstance().getJoueur().setDirection(0);
        handleMovement();
    }


    private void handleMovement() {
        Environnement env = Environnement.getInstance();
        boolean movingUp = pressedKeys.contains("UP");
        boolean movingDown = pressedKeys.contains("DOWN");
        boolean movingLeft = pressedKeys.contains("LEFT");
        boolean movingRight = pressedKeys.contains("RIGHT");
        boolean interact = pressedKeys.contains("E");
        boolean attaque = pressedKeys.contains("X");
        boolean inventaire = pressedKeys.contains("A");

        if (!this.inventaire_ouvert) {
            if (movingRight && movingLeft || movingDown && movingUp) {
                env.getJoueur().setDirection(5);
            } else if (movingUp && movingRight) {
                env.getJoueur().setDirection(9);
            } else if (movingUp && movingLeft) {
                env.getJoueur().setDirection(7);
            } else if (movingDown && movingLeft) {
                env.getJoueur().setDirection(1);
            } else if (movingDown && movingRight) {
                env.getJoueur().setDirection(3);
            } else if (movingUp) {
                env.getJoueur().setDirection(8);
            } else if (movingRight) {
                env.getJoueur().setDirection(6);
            } else if (movingDown) {
                env.getJoueur().setDirection(2);
            } else if (movingLeft) {
                env.getJoueur().setDirection(4);
            }
            if (attaque && cooldown) {
                env.getJoueur().setDirection(5);
                this.joueurVue.afficherArmeView();
                env.getJoueur().attaquer();
                cooldown = false;
            } else if (interact) {
                env.getJoueur().setInteraction(true);
            }
        } else {
            if (movingUp) {
                this.inv.deplacerSelect(8);
            } else if (movingRight) {
                this.inv.deplacerSelect(6);
            } else if (movingDown) {
                this.inv.deplacerSelect(2);
            } else if (movingLeft) {
                this.inv.deplacerSelect(4);
            } else if (interact) {
                this.inv.utiliserObjetSelect();
            }
        }
        if (inventaire) {
            pressedKeys.remove("A");
            //lanceMenuPause();
            inventaire_ouvert = this.inv.ouvrirInventaire();
        }

    }


    private void initAnimation() {
        gameLoop = new Timeline();
        gameLoop.setCycleCount(Timeline.INDEFINITE);
        temps_gameloop = 0;
        lastTime = System.currentTimeMillis();

        KeyFrame kf = new KeyFrame(
                Duration.seconds(0.017),
                ev -> {
                    long currentTime = System.currentTimeMillis();
                    lastTime = currentTime;

                    if (!inventaire_ouvert) {
                        Environnement.getInstance().unTour();

                        if (this.joueurVue.isVisible()) {
                            if (temps_gameloop % 30 == 0) {
                                this.joueurVue.getArmeView().setVisible(false);
                                cooldown = true;
                            }
                        }
                        if (this.joueurVue.isVisible()) { // Si le joueur fait une attaque alors pendant qu"elle que seconde l'arme s'affichera
                            if (temps_gameloop % 30 == 0) {
                                this.joueurVue.getArmeView().setVisible(false);
                                cooldown = true;
                            }
                        }
                    }
                    temps_gameloop++;
                }
        );

        gameLoop.getKeyFrames().add(kf);
    }
}

