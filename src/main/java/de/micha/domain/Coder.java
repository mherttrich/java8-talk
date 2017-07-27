package de.micha.domain;

import java.util.Set;

/**
 * Created by mherttrich on 26/07/17.
 */
public class Coder {

    private String firstname;
    private String lastname;
    private Set<String> skills;



    public Coder() {
    }

    public Coder(String firstname, String lastname, Set<String> skills) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.skills = skills;
    }

    public String getFirstname() {
        return firstname;
    }



    public String getLastname() {
        return lastname;
    }


    public Set<String> getSkills() {
        return skills;
    }

   
    @Override
    public String toString() {
        return "Coder{" +
                "firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", skills=" + skills +
                '}';
    }
}
