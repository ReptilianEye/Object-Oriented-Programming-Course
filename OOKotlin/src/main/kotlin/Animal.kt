import Vector2d.Companion.toUnitVector

class Animal(private var position: Vector2d = Vector2d(2, 2)) {
    private var orientation: MapDirection = MapDirection.NORTH

    fun getOrientation() = orientation

    fun getPosition() = position

    override fun toString(): String = orientation.toStringShort()

    fun isAt(position: Vector2d) = this.position == position


    fun move(direction: MoveDirection, validator: IMoveValidator): Vector2d {
        when (direction) {
            MoveDirection.FORWARD -> {
                val temp = position + orientation.toUnitVector()
                if (validator.canMoveTo(temp)) position = temp
            }

            MoveDirection.BACKWARD -> {
                val temp: Vector2d = position - orientation.toUnitVector()
                if (validator.canMoveTo(temp)) position = temp
            }

            MoveDirection.LEFT -> orientation = orientation.previous()
            MoveDirection.RIGHT -> orientation = orientation.next()
        }
        return position
    }
}
