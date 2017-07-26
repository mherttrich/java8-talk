package de.micha;

import com.google.common.collect.Sets;
import de.micha.external.EvilLib;
import de.micha.domain.Coder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.Assert.assertEquals;

/**
 * Created by mherttrich on 26/07/17.
 */
public class MyApp {


    private static EvilLib externalLib = new EvilLib();

    private static List<Coder> list;


    private static Coder leadDev;

    private static Set<String> coding = new HashSet<String>() {{
        add("java");
        add("perl");
    }};

    private static Set<String> several = new HashSet<String>() {{
        add("java");
        add("scrum");
    }};




    static {


        leadDev = new Coder("Brian", "Clever", several);

        list = new ArrayList<>();
        list.add(new Coder("Heinz", "Meier", coding));
        list.add(new Coder("Franz", "Schmidt", several));

    }


    public static void main(String[] args) {

        externalLib.printPretty(list);


        assertEquals(2, list.size());
        externalLib.printPretty(leadDev);
        assertEquals("Coder{firstname='Heinz', lastname='Meier', skills=[java, perl]}", list.get(0).toString());
        assertEquals("Coder{firstname='Franz', lastname='Schmidt', skills=[java, scrum]}", list.get(1).toString());
        assertEquals("Coder{firstname='Brian', lastname='Clever', skills=[java, scrum]}", leadDev.toString());
    }
}
