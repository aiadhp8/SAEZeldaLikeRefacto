package com.example.zeldalike.modele.entity.objetImmobile.objetRecuperable.arme;


import com.example.zeldalike.modele.Environnement;
import com.example.zeldalike.modele.entity.Position;
import com.example.zeldalike.modele.entity.objetImmobile.objetRecuperable.ObjetRecuperables;
import com.example.zeldalike.modele.entity.objetMobile.personnage.Personnage;
import com.example.zeldalike.modele.entity.objetMobile.personnage.ennemi.Ennemis;
import com.example.zeldalike.modele.entity.objetMobile.personnage.joueur.Joueur;


import java.util.ArrayList;


public abstract class Arme extends ObjetRecuperables {

    private final int attaque;

    public Arme(Position position, int attaque) {
        super(position);
        this.attaque = attaque;
    }

    public void hit(Ennemis e) {
        if (!e.isBouclierActif()) {
            e.subirDegats(Math.max(attaque - e.getDef(), 0));
        }
    }

    public abstract void faireUneAttaque();

    public ArrayList<Personnage> toucherPersonnage() {
        ArrayList<Personnage> ennemisProches = Environnement.getInstance().getJoueur().getEnnemisProches();
        ArrayList<Personnage> ennemisToucher = new ArrayList<Personnage>();
        for (Personnage ennemi : ennemisProches) {
            System.out.println(ennemi);
            if (ennemi != null) {
                if (this.inAtkRange(ennemi)) {
                    ennemisToucher.add(ennemi);
                }
            }
        }
        return ennemisToucher;
    }

    private boolean inAtkRange(Personnage ennemi) {
        int xTemp = Environnement.getInstance().getJoueur().getPosition().getX();
        int yTemp = Environnement.getInstance().getJoueur().getPosition().getY();
        Position positionArmeTemp = new Position(0,0,0,0);
        switch (Environnement.getInstance().getJoueur().getDirectionPrecedente()){
            case 1,2,3:
                positionArmeTemp = new Position(xTemp,yTemp+32,32,32);
                break;
            case 4:
                positionArmeTemp = new Position(xTemp-32,yTemp,32,32);

                break;
            case 7,8,9:
                positionArmeTemp = new Position(xTemp,yTemp-32,32,32);
                break;
            case 6:
                positionArmeTemp = new Position(xTemp+32,yTemp,32,32);
                break;
        }
        return positionArmeTemp.collision(ennemi.getPosition());
    }


}
