package demo.demo

import groovy.transform.CompileStatic

@CompileStatic
class EntityGenerator {
    static final Random random = new Random()
    static final String[] colors = ["red", "blue", "green"]
    static final Pet[] pets = Pet.values()

    static Entity generate(int garbage) {
        def e = new Entity()
        e.favoriteColor = colors[random.nextInt(colors.length)]
        e.pet = pets[random.nextInt(pets.length)]
        e.favoriteNumber = random.nextInt(3) + 1
        return e
    }
}
