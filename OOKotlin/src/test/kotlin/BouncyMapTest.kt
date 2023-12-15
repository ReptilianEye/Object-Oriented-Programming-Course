import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe
import io.kotest.matchers.shouldNotBe

class BouncyMapTest : FunSpec({

    test("place") {
        val map = BouncyMap(5, 5)
        val animal = Animal(Vector2d(2, 2))
        val animal2 = Animal(Vector2d(2, 2))

        map.place(animal)
        map.objectAt(Vector2d(2, 2)) shouldBe animal
        map.place(animal2)
        
    }

    test("move") {
        val map = BouncyMap(5, 5)
        val animal = Animal(Vector2d(2, 2))

        map.place(animal)
        map.move(animal, MoveDirection.FORWARD)

        val newPosition = animal.getPosition()
        newPosition shouldNotBe Vector2d(2, 2)
        map.objectAt(newPosition) shouldBe animal
    }

    test("isOccupied") {
        val map = BouncyMap(5, 5)
        val animal = Animal(Vector2d(2, 2))

        map.place(animal)
        map.isOccupied(Vector2d(2, 2)) shouldBe true
    }

    test("objectAt") {
        val map = BouncyMap(5, 5)
        val animal = Animal(Vector2d(2, 2))

        map.place(animal)
        map.objectAt(Vector2d(2, 2)) shouldBe animal
    }

    test("canMoveTo") {
        val map = BouncyMap(5, 5)
        val animal = Animal(Vector2d(2, 2))

        map.place(animal)
        map.canMoveTo(Vector2d(3, 3)) shouldBe true
    }
})
