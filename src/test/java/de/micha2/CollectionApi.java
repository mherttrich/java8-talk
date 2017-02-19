package de.micha2;

import org.junit.Test;

import java.io.File;
import java.util.*;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.stream.IntStream;

/**
 * Created by micha on 06.02.17.
 */
public class CollectionApi {

    class Node {
        private int identifier;
        public Node(){}
        public Node(int identifier) {
            this.identifier = identifier;
        }
        public int getIdentifier() {
            return identifier;
        }
        @Override
        public String toString() {
            return "Node{" +
                    "identifier=" + identifier +
                    '}';
        }
    }


    // Consumer<T>
    // a void method "accept" needs to get overwritten

    Consumer<File> prettyPrinter = f -> {
        System.out.println(f.length() + " " + f.getName());
    };


    @Test
    public void whatsnewAboutLists() {

        File[] files = new File("/Users/micha/Downloads/").listFiles();
        ArrayList<File> list = new ArrayList<>(Arrays.asList(files));

        list.removeIf(File::isDirectory);

        list.sort(Comparator.comparing(File::length)
                            .thenComparing(File::getName)
                            .reversed()
                );
        list.forEach(prettyPrinter);
    }

    BiFunction<Integer, Node, Node> biFunction = (key, value) -> new Node(key + value.identifier);

    @Test
    public void MapsMapsMaps() {
        Map<Integer, Node> map = new HashMap<>();
        IntStream.range(1, 10).forEach(i ->
                map.put(i, new Node(i))
        );

        /*if(map.containsKey(10)){
            map.put(...);
        }*/
        Node defaultNode = map.computeIfAbsent(15, p -> new Node(p));

        map.computeIfPresent(5, biFunction );

        Node alwaysSomething = map.getOrDefault(400, new Node());

        // check out whats the param ti foreach
        map.forEach((k,v)-> System.out.println(k + ": " +v.toString()));
    }
}