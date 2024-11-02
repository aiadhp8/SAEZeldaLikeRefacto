package com.example.zeldalike.modele.entity;

public abstract class Entity {
    private Position position;

    public Entity(Position position) {
        this.position = position;
    }

    public Position getPosition() {
        return position;
    }

    public int getHeight() {
        return this.position.getHeight();
    }

    public int getWidth() {
        return this.position.getWidth();
    }

    public boolean collision(Entity e){
        return this.position.collision(e.getPosition());
    }

    public double distance(Entity e){
        return this.position.distance(e.getPosition());
    }
}
