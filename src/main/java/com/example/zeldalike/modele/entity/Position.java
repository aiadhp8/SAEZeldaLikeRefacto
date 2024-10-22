package com.example.zeldalike.modele.entity;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

import java.awt.*;

public class Position {
    private final IntegerProperty x;
    private final IntegerProperty y;
    private Rectangle hitbox;

    public Position(int x, int y, Rectangle hitbox) {
        this.x = new SimpleIntegerProperty(x);
        this.y = new SimpleIntegerProperty(y);
        this.hitbox = hitbox;
    }

    public int getX() {
        return x.get();
    }

    public int getY() {
        return y.get();
    }

    public void setX(int x) {
        this.x.set(x);
    }

    public void setY(int y) {
        this.y.set(y);
    }

    public IntegerProperty xProperty() {
        return x;
    }

    public IntegerProperty yProperty() {
        return y;
    }

    public boolean collision(Position p) {
        return hitbox.intersects(p.hitbox);
    }

    @Override
    public String toString() {
        return "Position{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}

