/**
 * The interface responsible for interacting with the map of the world.
 * Assumes that Vector2d and MoveDirection classes are defined.
 *
 * @author apohllo, idzik
 */
interface IWorldMap : IMoveValidator {
    /**
     * Place a value on the map.
     *
     * @param element The value to place on the map.
     * @return True if the animal was placed. The animal cannot be placed if the move is not valid.
     */
    @Throws(PositionAlreadyOccupiedException::class)
    fun place(element: Animal)

    /**
     * Moves an animal (if it is present on the map) according to specified direction.
     * If the move is not possible, this method has no effect.
     */
    fun move(element: Animal, direction: MoveDirection)

    /**
     * Return true if given position on the map is occupied. Should not be
     * confused with canMove since there might be empty positions where the animal
     * cannot move.
     *
     * @param position Position to check.
     * @return True if the position is occupied.
     */
    fun isOccupied(position: Vector2d): Boolean

    /**
     * Return an animal at a given position.
     *
     * @param position The position of the animal.
     * @return animal or null if the position is not occupied.
     */
    fun objectAt(position: Vector2d): Animal?
    override fun canMoveTo(position: Vector2d): Boolean
}
