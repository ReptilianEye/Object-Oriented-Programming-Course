class PositionAlreadyOccupiedException internal constructor(position: Vector2d) :
    Exception("Position $position is already occupied")
