package com.example.zeldalike.modele.entity.objetMobile.deplacements;

import com.example.zeldalike.modele.Environnement;
import com.example.zeldalike.modele.entity.Position;

public class DeplacementBFS implements StrategieDeplacements{


    @Override
    public int nouvelleDirection(int direction, Position p) {
        int indiceposition = Environnement.getInstance().getTerrain().getIndiceCaseSousPosition(p.getX(),p.getY());
        int indicevalmin = Environnement.getInstance().getCarteBFS().indiceMinimumVal(indiceposition);

        return Environnement.getInstance().getTerrain().getDirectionI1versI2(indiceposition, indicevalmin);
    }
}
