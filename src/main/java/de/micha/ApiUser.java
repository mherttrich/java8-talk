package de.micha;

import de.micha.Api.ApiProvider;
import de.micha.domain.Coder;

import java.util.List;

/**
 * Created by mherttrich on 26/07/17.
 */
public class ApiUser {

    private static ApiProvider api = new ApiProvider();

    public static void main(String[] args) {

        List<Coder> coders = api.getCoders();




        List<Coder> untouched = api.getOriginalUntouchedVirginCoderList();


    }




}
