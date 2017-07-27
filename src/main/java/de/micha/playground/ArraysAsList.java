package de.micha.playground;

import java.util.Arrays;
import java.util.List;
import java.util.function.UnaryOperator;

/**
 * Created by mherttrich on 27/07/17.
 */
public class ArraysAsList
{

    public static void main(String[] args) {
        List<String> list = Arrays.asList("H", "a", "l","l","o");
        //List backed by fixed size array, no add, remove

        //list.add("k");
        //list.remove("k");




        System.out.println(list);
    }
}
