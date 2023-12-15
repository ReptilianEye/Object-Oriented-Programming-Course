import RandomExtensions.Companion.randomFreePosition
import RandomExtensions.Companion.randomPosition

class BouncyMap(width: Int, height: Int) : IWorldMap {
    private val leftBound = Vector2d(0, 0)
    private val rightBound = Vector2d(width, height)

    private var map: Map<Vector2d, Animal> = mutableMapOf()

    override fun place(element: Animal) {
        map = map.filterValues { it != element }
        val pos = element.getPosition()
        if (map[pos] != null) {
            map.randomFreePosition(rightBound)?.let { freePos -> map += (freePos to element) } ?: map.randomPosition()
                ?.let { p -> map += (p to element) }
        } else map += pos to element

    }

    override fun move(element: Animal, direction: MoveDirection) {
        val prevPos = element.getPosition()
        val newPos = element.move(direction, this)
        if (prevPos != newPos) {
            map = map.filter { (p, _) -> p == prevPos }
            try {
                place(element)
            } catch (ignored: PositionAlreadyOccupiedException) {
                return
            }
        }
    }

    override fun isOccupied(position: Vector2d) = map[position] != null


    override fun objectAt(position: Vector2d) = map[position]

    override fun canMoveTo(position: Vector2d) = leftBound <= position && position <= rightBound

}

