package agh.ics.oop.model;

import java.util.Objects;

public class Vector2d {
    private final int x;
    private final int y;

    public Vector2d(int x, int y) {
        this.x = x;
        this.y = y;
    }

    int getX() {
        return this.x;
    }

    int getY() {
        return this.y;
    }

    public String toString() {
        return String.format("(%d,%d)", this.getX(), this.getY());
    }

    public boolean precedes(Vector2d other) {
        return this.getX() <= other.getX() && this.getY() <= other.getY();
    }

    public boolean follows(Vector2d other) {
        return this.getX() >= other.getX() && this.getY() >= other.getY();
    }

    public Vector2d add(Vector2d other) {
        return new Vector2d(this.getX() + other.getX(), this.getY() + other.getY());
    }

    public Vector2d subtract(Vector2d other) {
        return new Vector2d(this.getX() - other.getX(), this.getY() - other.getY());
    }

    public Vector2d upperRight(Vector2d other) {
        return new Vector2d(Math.max(this.getX(), other.getX()), Math.max(this.getY(), other.getY()));
    }

    public Vector2d lowerLeft(Vector2d other) {
        return new Vector2d(Math.min(this.getX(), other.getX()), Math.min(this.getY(), other.getY()));
    }

    public Vector2d opposite() {
        return new Vector2d(-this.getX(), -this.getY());
    }

    public boolean equals(Object other) {
        if (this == other)
            return true;
        if (!(other instanceof Vector2d that))
            return false;
        return Objects.equals(this.getX(), that.getX()) && Objects.equals(this.getY(), that.getY());
    }

    public int hashCode() {
        return Objects.hash(this.getX(), this.getY());
    }
}
