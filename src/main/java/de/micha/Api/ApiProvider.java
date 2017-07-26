package de.micha.Api;

import com.google.common.collect.ImmutableList;
import de.micha.domain.Coder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import static org.junit.Assert.assertEquals;

/**
 * Created by mherttrich on 26/07/17.
 */
public class ApiProvider {

    private static List<Coder> list;


    static{
        list = new ArrayList<>();
        list.add(new Coder("Heinz", "Meier", 30));
        list.add(new Coder("Franz", "Schmidt", 40));



    }


    public List<Coder> getCoders(){
        return list;
    }

    public List<Coder> getOriginalUntouchedVirginCoderList(){
        assertEquals(2, list.size());

        assertEquals(new Coder("Heinz", "Meier", 30),list.get(0));
        assertEquals(new Coder("Franz", "Schmidt", 40),list.get(1));

    return list;
    }









}
