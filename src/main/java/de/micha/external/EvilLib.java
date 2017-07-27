package de.micha.external;

import de.micha.domain.Coder;

import java.util.List;
import java.util.Set;

/**
 * Created by mherttrich on 26/07/17.
 */
public class EvilLib {


    public void printPretty(List<Coder> coders) {
        coders.forEach(System.out::println);
        // someone might do something stupid
        // coders.add(new Coder("","", null));
        System.out.println();
    }

    public  void printPretty(Coder coder) {
        // someone might do something stupid
        // coder.getSkills().add("vmpro");
        System.out.println(coder);
    }
}
