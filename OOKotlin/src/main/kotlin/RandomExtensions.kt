open class RandomExtensions {
    companion object {
        fun Map<Vector2d, Any>.randomPosition() = this.keys.randomOrNull()
        fun Map<Vector2d, Any>.randomFreePosition(mapSize: Vector2d) =
            ((0..mapSize.x) zip (0..mapSize.y)).map { (x, y) -> Vector2d(x, y) }
                .filter { v -> !this.keys.contains(v) }.randomOrNull()
    }
}