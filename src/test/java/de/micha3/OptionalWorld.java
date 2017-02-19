package de.micha3;

import de.domain.Adress;
import de.domain.City;
import de.domain.Person;
import org.junit.Test;

import java.util.Optional;

/**
 * Created by micha on 14.02.17.
 */
public class OptionalWorld {


    @Test
    public void onlyNiceWords(){
        Optional<String> word = Optional.of("I say nice words");
                     word
                    //what is the result of a filtered Optional?
                    //could be a empty optional
                    .filter(x -> !x.contains("badword"))
                    // we could map it from String to a Message or a person
                    .map(x -> "message is:" + x)
                    .ifPresent(System.out::println);
    }



    @Test
    public void testMyOpt() {
        Person person = new Person("Angela", Person.Gender.FEMALE, 150, 60);
        Adress address = new Adress("Reichstagsstrasse 22", new City("12245"));
        person.setAdress(address);
        Optional<Person> personOptional = Optional.of(person);
        //avoid nested optionals (Optional<Optional<String>)

        String zipcode = personOptional.flatMap(Person::getAdress)
                .flatMap(Adress::getCity)
                .flatMap(City::getZipCode)
                .orElse("unknown");
        System.out.println(zipcode);
    }
}
