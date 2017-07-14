package de.micha;

import de.micha.api.Programmer;
import de.micha.api.ProgrammerMasterService;

import java.util.List;

/**
 * Created by micha on 14.07.17.
 */
public class ApiUser {
    public static void main(String[] args) {
        ProgrammerMasterService someapi = new ProgrammerMasterService();
        List<Programmer> list = someapi.get();
        list.add(new Programmer("fran", "z"));


        list.forEach(System.out::println);


    }
}
