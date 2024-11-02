package com.example.zeldalike.modele.entity;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

import java.awt.*;

public class Position {
    private final IntegerProperty x;
    private final IntegerProperty y;
    private final int height;
    private final int width;

    public Position(int x, int y, int height, int width) {
        this.x = new SimpleIntegerProperty(x);
        this.y = new SimpleIntegerProperty(y);
        this.height = height;
        this.width = width;
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

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    public boolean collision(Position p) {
        return this.getX() < p.getX() + p.getWidth() &&
                this.getX() + this.getWidth() > p.getX() &&
                this.getY() < p.getY() + p.getHeight() &&
                this.getY() + this.getHeight() > p.getY();
    }

    public double distance(Position p) {
        int deltaX = this.getX() - p.getX();
        int deltaY = this.getY() - p.getY();
        return Math.sqrt(deltaX * deltaX + deltaY * deltaY);
    }


    @Override
    public String toString() {
        return "Position{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}

