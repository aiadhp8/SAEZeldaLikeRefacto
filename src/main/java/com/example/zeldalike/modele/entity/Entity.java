package com.example.zeldalike.modele.entity;

public abstract class Entity {
    private Position position;

    public Entity(Position position) {
        this.position = position;
    }

    public Position getPosition() {
        return position;
    }
}
