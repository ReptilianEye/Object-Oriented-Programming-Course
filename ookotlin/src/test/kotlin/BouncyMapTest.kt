import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe
import io.kotest.matchers.shouldNotBe

class BouncyMapTest : FunSpec({
    test("place correctly when free space") {
        val map = BouncyMap(5, 5)
        val animal = Animal(Vector2d(2, 2))

        map.place(animal)
        map.objectAt(Vector2d(2, 2)) shouldBe animal
    }
    test("place and bounce") {
        val map = BouncyMap(5, 5)
        val animal = Animal(Vector2d(2, 2))
        val animal2 = Animal(Vector2d(2, 2))
        map.place(animal)
        map.place(animal2)
        val animalMap = BouncyMap::class.java.getDeclaredField("map").also { it.isAccessible = true }
            .get(map) as Map<Vector2d, Animal>
        val posOfSecondAnimal = animalMap.filterValues { it == animal2 }.keys.first()
        posOfSecondAnimal shouldNotBe Vector2d(2, 2)
        map.canMoveTo(posOfSecondAnimal) shouldBe true
    }
    test("place and replace if no slots are available") {
        val map = BouncyMap(1, 1)
        val animal1 = Animal(Vector2d(0, 0))
        val animal2 = Animal(Vector2d(0, 1))
        val animal3 = Animal(Vector2d(1, 0))
        val animal4 = Animal(Vector2d(1, 1))
        map.place(animal1)
        map.place(animal2)
        map.place(animal3)
        map.place(animal4)
        val animal5 = Animal(Vector2d(0, 0))
        map.place(animal5)
        val animalMap = BouncyMap::class.java.getDeclaredField("map").also { it.isAccessible = true }
            .get(map) as Map<Vector2d, Animal>
        val posOfLast = animalMap.filterValues { it == animal5 }.keys.firstOrNull()
        posOfLast shouldNotBe null
        map.canMoveTo(posOfLast!!) shouldBe true

    }

    test("move") {
        val map = BouncyMap(5, 5)
        val startingPos = Vector2d(2, 2)
        val animal = Animal(startingPos)

        map.place(animal)
        map.move(animal, MoveDirection.FORWARD)

        val newPosition = animal.getPosition()
        newPosition shouldNotBe Vector2d(2, 2)
        map.objectAt(newPosition) shouldBe animal
        map.isOccupied(startingPos) shouldBe false
    }

    test("isOccupied") {
        val map = BouncyMap(5, 5)
        val animal = Animal(Vector2d(2, 2))

        map.place(animal)
        map.isOccupied(Vector2d(2, 2)) shouldBe true
        map.isOccupied(Vector2d(0, 0)) shouldBe false
    }

    test("objectAt") {
        val map = BouncyMap(5, 5)
        val animal = Animal(Vector2d(2, 2))

        map.place(animal)
        map.objectAt(Vector2d(2, 2)) shouldBe animal
    }

    test("canMoveTo") {
        val map = BouncyMap(10, 10)
        val inBound1 = Vector2d(5, 5)
        val inBound2 = Vector2d(5, 10)
        val inBound3 = Vector2d(10, 5)
        val outBound1 = Vector2d(50, 50)
        val outBound2 = Vector2d(-50, -50)

        map.canMoveTo(inBound1) shouldBe true
        map.canMoveTo(inBound2) shouldBe true
        map.canMoveTo(inBound3) shouldBe true

        map.canMoveTo(outBound1) shouldBe false
        map.canMoveTo(outBound2) shouldBe false

    }
})
