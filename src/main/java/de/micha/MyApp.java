package de.micha;

import com.google.common.collect.ImmutableList;
import de.micha.domain.Coder;
import de.micha.external.EvilLib;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
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


        //java.util
        //list = Collections.unmodifiableCollection(new ArrayList<String>());

        // guava
        list = ImmutableList.of(
                new Coder.Builder("Heinz")
                        .addLastname("Meier")
                        .addSkills(coding)
                        .build(),

                new Coder.Builder("Franz")
                        .addLastname("Schmidt")
                        .addSkills(several)
                        .build()
                );

        leadDev = new Coder.Builder("Brian")
                .addLastname("Clever")
                .addSkills( several).build();
    }


    public static void main(String[] args) {



        externalLib.printPretty(list);

        //someone might hold still a reference to what we used on construction
        several.add("feed the cat");

        assertEquals(2, list.size());
        assertEquals("Coder{firstname='Heinz', lastname='Meier', skills=[java, perl]}", list.get(0).toString());
        assertEquals("Coder{firstname='Franz', lastname='Schmidt', skills=[java, scrum]}", list.get(1).toString());


        externalLib.printPretty(leadDev);
        assertEquals("Coder{firstname='Brian', lastname='Clever', skills=[java, scrum]}", leadDev.toString());
    }
}
