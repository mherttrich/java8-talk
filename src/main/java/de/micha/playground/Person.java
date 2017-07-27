package de.micha.playground;

import java.util.Set;

/**
 * Created by mherttrich on 26/07/17.
 */
public  class Person {
    private  Set<String> hobbies;


     Person(Set<String> h) {
        this.hobbies = h;
    }

    public Set<String> getHobbies() {
        return hobbies;
    }

    @Override
    public String toString() {
        return "Person{" +
                "hobbies=" + hobbies +
                '}';
    }
}
