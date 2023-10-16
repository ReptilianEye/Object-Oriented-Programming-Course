package agh.ics.oop.model;


public enum MapDirection {

    NORTH, EAST, SOUTH, WEST;
    private static final MapDirection[] vals = values();

    public String toString() {
        return switch (this) {
            case NORTH -> "Północ";
            case EAST -> "Wschód";
            case SOUTH -> "Południe";
            case WEST -> "Zachód";
        };
    }

    public MapDirection next() {
        return vals[(this.ordinal() + 1) % vals.length];
    }

    public MapDirection previous() {
        int i = this.ordinal() == 0 ? vals.length - 1 : this.ordinal() - 1;
        return vals[i];
    }

    public Vector2d toUnitVector() {
        return switch (this) {
            case NORTH -> new Vector2d(0, -1);
            case EAST -> new Vector2d(1, 0);
            case SOUTH -> new Vector2d(0, 1);
            case WEST -> new Vector2d(-1, 0);
        };
    }
}
