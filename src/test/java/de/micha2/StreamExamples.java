package de.micha2;

import com.google.common.collect.ImmutableList;
import de.domain.Person;
import org.junit.Test;

import java.io.File;
import java.util.*;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;


/**
 * Created by micha on 04.02.17.
 */
public class StreamExamples {
    static final Set<String> de = new HashSet<>(Arrays.asList("deutsch"));
    static final Set<String> de_en = new HashSet<>(Arrays.asList("deutsch", "englisch"));
    static final Set<String> de_es = new HashSet<>(Arrays.asList("deutsch",  "spanisch"));
    static final Set<String> de_en_pt = new HashSet<>(Arrays.asList("deutsch", "englisch", "portugisisch"));

    static final ImmutableList<Person> persons = ImmutableList.of(
            new Person("Hans", Person.Gender.MALE, 184, 43, de_es),
            new Person("Katja", Person.Gender.FEMALE, 174, 40, de_en_pt),
            new Person("Lucia", Person.Gender.FEMALE, 98, 5, de),
            new Person("Hannelore", Person.Gender.FEMALE, 170, 74, de_en),
            new Person("Santa Claus", Person.Gender.MALE, 175, 75, de)
    );



    // Consumer<T>
    // a void method "accept" needs to get overwritten

    Consumer<File> prettyPrinter = f -> {
        System.out.println(f.length() + " " + f.getName());
    };

    //stream.foreach will to this with a consumer:
    //prettyPrinter.accept(person);


    Predicate<Person> isTall = (Person p) -> {
        return p.getHeight() > 174;
    };

    //shorter
    Predicate<Person> isTall2 = p -> p.getHeight() > 174;

    // stream.filter will do the following:
    // isTall.test(person);

    @Test
    public void playwithStream() {

        int adult =18;  //can we access the var inside the lambda?
        List<Person> filtered =
                persons
                .stream()
                .filter(x -> x.getAge() > adult)  //what's the parameter to filter function?
                .collect(Collectors.toList());
        filtered.forEach(System.out::println);
    }

    @Test
    public void personAsMap() {
        Map<String, Integer> map = persons
                .stream()
                .collect(Collectors.toMap(Person::getName, p->p.getHeight()));

        Long count = persons.stream().collect(Collectors.counting());

        Double averageHeight = persons.stream().collect(Collectors.averagingDouble(Person::getHeight));

    }

    @Test
    public void severalStuff() {
        // we want to get a List of Man and Woman .....
        Map<Person.Gender, List<Person>> collect = persons
                .stream()
                .collect(Collectors.groupingBy(Person::getGender));

        // the youngest person (min)
        Person teeny = persons
                .stream()
                .min(Comparator.comparing(Person::getAge))
                .orElseThrow(() -> new RuntimeException("list was empty"));
    }



    @Test
    public void filterCollect() {

        List<Person> result = persons
                .stream()
                .filter(x -> x.getAge() > 18)  //what's the parameter to filter function?
                .filter(isTall)
                // or like this (might have different result, why?)
                .filter(Person::isTall)
                .collect(Collectors.toList());

        //foreach works on streams and collections
        result.forEach(System.out::println);

    }

    @Test
    public void filterAndCollect() {
        // if name is same, than we consider height
        // be are prepared that height might be null

        persons.stream()
                .sorted(Comparator.comparing(Person::getName)
                        .thenComparing(
                                p -> {
                                    return p.getHeight() != null ? p.getHeight() : Integer.MIN_VALUE;
                                })
                )
                .forEach(System.out::println);
    }




    @Test
    public void findSomeThing() {
          persons
                .stream()
                  .peek(x -> System.out.println("peek:" + x))
                  //filter on the predicate above
                  .findAny();
          //find any might find nothing, if the filter is to eager
          //that's why we will get an optional

    }

    @Test
    public void pleasePeek() {
        persons
                .stream()
                // this is a good way to debug, if your filter works
                // think about the diffence between foreach and peek
                .peek(x -> System.out.println("before filter:" + x))
                .filter(isTall)
                .peek(x -> System.out.println("after filter:" + x));

                 // will we see the prints of the peek?
                 // think about intermediate and terminal operations
    }


    @Test
    public void streamBigList() {
        //imagine U stream a very big list of 3 mio persons
        persons
                .parallelStream()
                /*
                .....

                 */
        ;
    }


    @Test
    public void invokePredicateMyself(){
        Person p = new Person("Michael", Person.Gender.MALE, 184, 43);
        boolean test = isTall.test(p);
    }

    @Test
    public void mapAndFlatMapThatStuff(){
         persons.stream()
                 .map(p -> p.getLanguages());
         persons.stream()
                .map(p -> p.getLanguages().stream());
    }

    @Test
    public void mapToInt(){
        // but I want a stream of primitive ints
        persons.stream().mapToInt(Person::getHeight);
        //there is much more like
        //              .mapToDouble(...)
    }
}
