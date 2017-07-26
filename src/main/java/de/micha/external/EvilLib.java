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
        System.out.println();
    }

    public  void printPretty(Coder coder) {

        System.out.print(coder);
        System.out.println();
    }
}
