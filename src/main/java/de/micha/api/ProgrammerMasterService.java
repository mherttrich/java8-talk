package de.micha.api;


import com.google.common.collect.ImmutableList;

import java.util.Arrays;
import java.util.List;

/**
 * Created by micha on 14.07.17.
 */


public class ProgrammerMasterService {

    static List<Programmer> list;
    static{
        list= ImmutableList.copyOf(
                Arrays.asList(
                        new Programmer("hans", "jürgen"),
                        new Programmer("erich", "kästner")));

    }

    public List<Programmer> get() {
        return list;
    }

    public somethingElse(){
        //list.whatever
    }


}
