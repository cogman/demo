package demo.demo

import groovy.transform.CompileStatic

@CompileStatic
class Main {
    static void main(String[] args) {
        (1..6)
                .collect { (int) Math.pow(10.0d, (double) it) }
                .forEach(Main.&runDedup)
    }

    static runDedup(int numElements) {
        List<Entity> e = []
        (1..numElements).collect(e, EntityGenerator.&generate)
        def start = System.currentTimeMillis()
        def result = deduplicate(e)
        def end = System.currentTimeMillis()
        println("Cut down " + numElements + " to " + result.size() + " in " + (end - start) + "ms")
    }

    static List<Entity> deduplicate(List<Entity> entities) {
        List<Entity> nonDuplicates = []
        nonDuplicates.addAll(entities)
        for (def i = nonDuplicates.listIterator(); i.hasNext();  ) {
            def entity = i.next()
            for (int j = i.nextIndex(); j < nonDuplicates.size(); ++j)
                if (matches(nonDuplicates[j], entity)) {
                    i.remove()
                    break
                }
        }
        return nonDuplicates
    }

    static boolean matches(Entity a, Entity b) {
        return a == b
    }
}
