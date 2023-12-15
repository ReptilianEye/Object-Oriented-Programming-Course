enum class MapDirection {
    NORTH, EAST, SOUTH, WEST;

    companion object {
        private val VALUES = entries;
    }

    override fun toString() = when (this) {
        NORTH -> "North"
        EAST -> "East"
        SOUTH -> "South"
        WEST -> "West"
    };

    fun toStringShort() = when (this) {
        NORTH -> "N";
        EAST -> "E";
        SOUTH -> "S";
        WEST -> "W";
    }

    fun toStringArrows() = when (this) {
        NORTH -> "^";
        EAST -> ">";
        SOUTH -> "v";
        WEST -> "<";
    };

    fun next() = VALUES[(ordinal + 1) % VALUES.size];

    fun previous(): MapDirection = VALUES[if (ordinal == 0) VALUES.size - 1 else ordinal - 1];


}
