package de.micha.playground;

import com.google.common.collect.ImmutableList;
import de.micha.domain.Coder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by mherttrich on 26/07/17.
 */
public class Cheet {

    public static void main(String[] args) {

        //nope
        ArrayList<Coder> list = new ArrayList<>();


        List<Coder> c2 = Collections.unmodifiableList(list);

        ImmutableList.copyOf(list);
        //ImmutableList.of(new Coder2(), new Coder2());

        //Arrays.asList(new Coder2("Heinz", "Meier", null), new Coder2("Franz", "Schmidt",null));

    }


}
