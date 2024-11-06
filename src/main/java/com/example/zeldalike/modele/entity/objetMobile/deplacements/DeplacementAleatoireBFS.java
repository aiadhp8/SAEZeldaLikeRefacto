package com.example.zeldalike.modele.entity.objetMobile.deplacements;

import com.example.zeldalike.modele.Environnement;
import com.example.zeldalike.modele.entity.Position;

public class DeplacementAleatoireBFS implements StrategieDeplacements {
    private DeplacementBFS dpbfs;
    private DeplacementAleatoires dpalea;

    public DeplacementAleatoireBFS(){
        this.dpalea = new DeplacementAleatoires();
        this.dpbfs = new DeplacementBFS();
    }

    @Override
    public int nouvelleDirection(int direction, Position p) {
        int indiceposition = Environnement.getInstance().getTerrain().getIndiceCaseSousPosition(p.getX(), p.getY());
        int indicepositionvaleur = Environnement.getInstance().getCarteBFS().getValeurCaseI(indiceposition);
        int indicevalmin = Environnement.getInstance().getCarteBFS().indiceMinimumVal(indiceposition);
        int indicevalminvaleur = Environnement.getInstance().getCarteBFS().getValeurCaseI(indicevalmin);

        if (indicevalminvaleur < indicepositionvaleur){
            return this.dpbfs.nouvelleDirection(direction, p);
        }
        else {
            return this.dpalea.nouvelleDirection(direction, p);
        }

    }
}
