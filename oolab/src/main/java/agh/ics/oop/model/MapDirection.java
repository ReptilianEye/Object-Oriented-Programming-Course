package agh.ics.oop.model;


public enum MapDirection {

    NORTH, EAST, SOUTH, WEST;
    private static final MapDirection[] VALUES = values();

    public String toString() {
        return switch (this) {
            case NORTH -> "Północ";
            case EAST -> "Wschód";
            case SOUTH -> "Południe";
            case WEST -> "Zachód";
        };
    }

    public String toStringShort() {
        return switch (this) {
            case NORTH -> "N";
            case EAST -> "E";
            case SOUTH -> "S";
            case WEST -> "W";
        };
    }

    public String toStringArrows() {
        return switch (this) {
            case NORTH -> "^";
            case EAST -> ">";
            case SOUTH -> "v";
            case WEST -> "<";
        };
    }

    public MapDirection next() {
        return VALUES[(this.ordinal() + 1) % VALUES.length];
    }

    public MapDirection previous() {
        int i = this.ordinal() == 0 ? VALUES.length - 1 : this.ordinal() - 1;
        return VALUES[i];
    }

    public Vector2d toUnitVector() {
        return switch (this) {
            case NORTH -> new Vector2d(0, 1);
            case EAST -> new Vector2d(1, 0);
            case SOUTH -> new Vector2d(0, -1);
            case WEST -> new Vector2d(-1, 0);
        };
    }
}
