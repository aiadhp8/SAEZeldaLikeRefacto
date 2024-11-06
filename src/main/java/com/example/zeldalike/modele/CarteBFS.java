package com.example.zeldalike.modele;

import com.example.zeldalike.modele.entity.objetMobile.personnage.joueur.Joueur;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class CarteBFS {

    private static final int PASSAGE_INTERDIT = 64;
    private final int[] carte;
    private final Joueur joueur;
    private final Terrain terrain;
    private final int largeur;
    private final int distanceMax;

    public CarteBFS(Terrain terrain, Joueur joueur) {
        this.joueur = joueur;
        this.terrain = terrain;
        this.carte = new int[terrain.tailleTerrain()];
        this.distanceMax = 11;
        this.largeur = terrain.getTailleLargeur();
        reinitCarte();
    }

    public void reinitCarte() {
        for (int i = 0; i < this.carte.length; i++) {
            this.carte[i] = terrain.codeCaseI(i) == 2 ? distanceMax + 1 : PASSAGE_INTERDIT;
        }
    }

    public void miseAJourCarte() {
        reinitCarte();

        int startX = joueur.getP().getX() + joueur.getHitbox();
        int startY = joueur.getP().getY() + joueur.getHitbox();
        int startIdx = terrain.getIndiceCaseSousPosition(startX, startY);

        LinkedList<Integer> marques = new LinkedList<>();
        LinkedList<Integer> temp = new LinkedList<>();
        marques.addFirst(startIdx);

        int distance = 0;
        while (distance < distanceMax) {
            transferElements(marques, temp);
            processCurrentDistance(temp, marques, distance);
            distance++;
        }
    }

    private void transferElements(LinkedList<Integer> source, LinkedList<Integer> target) {
        while (!source.isEmpty()) {
            target.add(source.pollLast());
        }
    }

    private void processCurrentDistance(LinkedList<Integer> temp, LinkedList<Integer> marques, int distance) {
        while (!temp.isEmpty()) {
            int current = temp.pollLast();
            this.carte[current] = distance;
            addValidAdjacentIndices(marques, temp, current, distance);
        }
    }

    private void addValidAdjacentIndices(LinkedList<Integer> marques, LinkedList<Integer> temp, int current, int distance) {
        for (int indice : terrain.getIndicesAdjacentsAvecIndice(current)) {
            if (isIndiceEligible(marques, temp, indice, distance)) {
                marques.addFirst(indice);
            }
        }
    }

    private boolean isIndiceEligible(LinkedList<Integer> marques, LinkedList<Integer> temp, int indice, int distance) {
        return !marques.contains(indice) && !temp.contains(indice) && this.carte[indice] > distance && this.carte[indice] != PASSAGE_INTERDIT;
    }

    public int getValeurCaseI(int i) {
        return this.carte[i];
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < this.carte.length; i++) {
            sb.append(" ");
            if (this.carte[i] < 10) {
                sb.append("0");
            }
            sb.append(this.carte[i]).append(",");
            if ((i + 1) % this.largeur == 0) {
                sb.append("\n");
            }
        }
        return sb.toString();
    }

    public int indiceMinimumVal(int indicePosition) {
        List<Integer> adj = terrain.getIndicesAdjacentsAvecIndice(indicePosition);
        return adj.isEmpty() ? -1 : findIndiceWithMinimumValue(adj);
    }

    private int findIndiceWithMinimumValue(List<Integer> indices) {
        int minIndice = indices.get(0);
        int minValue = carte[minIndice];

        for (int indice : indices) {
            if (carte[indice] < minValue) {
                minValue = carte[indice];
                minIndice = indice;
            }
        }
        return minIndice;
    }

    public int minimumValdesCases(ArrayList<Integer> cases) {
        if (cases.isEmpty()) {
            return PASSAGE_INTERDIT;
        }
        return cases.stream().mapToInt(i -> carte[i]).min().orElse(PASSAGE_INTERDIT);
    }

    public ArrayList<Integer> tousIndicesMinimum(ArrayList<Integer> adj) {
        ArrayList<Integer> plusPetits = new ArrayList<>();
        int minValue = minimumValdesCases(adj);

        for (int val : adj) {
            if (this.carte[val] == minValue) {
                plusPetits.add(val);
            }
        }
        return plusPetits;
    }
}

