package demo.demo

import groovy.transform.CompileStatic

@CompileStatic
class Main {
    static void main(String[] args) {
        (1..7)
                .collect { (int) Math.pow(10.0d, (double) it) }
                .forEach(Main.&runGrouping)
    }

    static runGrouping(int numElements) {
        List<Entity> e = []
        (1..numElements).collect(e, EntityGenerator.&generate)
        def start = System.currentTimeMillis()
        def result = groupBy(e)
        def end = System.currentTimeMillis()
        println("In " + numElements + " found " + result + " who had fish pet, favorite number 3, favorite color red.  Took " + (end - start) + "ms" )
    }

    static Number groupBy(List<Entity> entities) {
        entities.findAll { (3 == it.favoriteNumber) }
                .findAll { it.pet == Pet.fish }
                .count { it.favoriteColor == "red" }
    }
}
