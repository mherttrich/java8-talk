package de.micha.playground;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by mherttrich on 26/07/17.
 */
public class MyApp2 {

    public static void main(String[] args) {



        Person person = new Person(new HashSet<String>() {{
            add("running");
            add("football");
        }});

        Person2 person2 = (Person2) person;
        person2.setHobbies(new HashSet<String>() {{
            add("sleep");
            add("read");
        }});


        System.out.println(person);
        //can we mute the Person?

    }

}
