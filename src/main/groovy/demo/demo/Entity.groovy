package demo.demo

import groovy.transform.CompileStatic
import groovy.transform.EqualsAndHashCode
import groovy.transform.ToString

@CompileStatic
@EqualsAndHashCode
@ToString
class Entity {
    int favoriteNumber
    String favoriteColor
    Pet pet
}
