import kotlin.math.max
import kotlin.math.min

data class Vector2d(
    val x: Int, val y: Int
) {
    companion object {
        fun MapDirection.toUnitVector() = when (this) {
            MapDirection.NORTH -> Vector2d(0, 1);
            MapDirection.EAST -> Vector2d(1, 0);
            MapDirection.SOUTH -> Vector2d(0, -1);
            MapDirection.WEST -> Vector2d(-1, 0);
        };
    }

    override fun toString() = "$x, $y"

    operator fun compareTo(other: Vector2d): Int {
        val diffX = x - other.x
        val diffY = x - other.x
        if (diffX > 0 && diffY > 0) return 1
        if (diffX < 0 && diffY < 0) return -1
        return 0
    }

//    fun precedes(other: Vector2d) = this < other;

//    fun follows(other: Vector2d) = this > other;

    operator fun plus(other: Vector2d) = Vector2d(x + other.x, y + other.y);

    operator fun minus(other: Vector2d) = Vector2d(x - other.x, y - other.y);

    fun upperRight(other: Vector2d) =
        Vector2d(max(x, other.x), max(y, other.y));

    fun lowerLeft(other: Vector2d) = Vector2d(min(x, other.x), min(y, other.y));

    fun opposite() = Vector2d(-x, -y);

    fun isLegal(bottomLeftBound: Vector2d, upperRightBound: Vector2d) =
        bottomLeftBound < this && this < upperRightBound


}
