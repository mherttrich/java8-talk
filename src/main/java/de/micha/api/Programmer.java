package de.micha.api;

/**
 * Created by micha on 14.07.17.
 */
public class Programmer {
    private String name;
    private String Lastname;

    //what about builder (see tt repo)

    public Programmer(String name, String lastname) {
        this.name = name;
        Lastname = lastname;
    }

    public String getName() {
        return name;
    }
}
