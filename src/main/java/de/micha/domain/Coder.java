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

    public Coder(String firstname, String lastname, Set skills) {
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Coder coder = (Coder) o;

        if (firstname != null ? !firstname.equals(coder.firstname) : coder.firstname != null) return false;
        if (lastname != null ? !lastname.equals(coder.lastname) : coder.lastname != null) return false;
        return skills != null ? skills.equals(coder.skills) : coder.skills == null;
    }

    @Override
    public int hashCode() {
        int result = firstname != null ? firstname.hashCode() : 0;
        result = 31 * result + (lastname != null ? lastname.hashCode() : 0);
        result = 31 * result + (skills != null ? skills.hashCode() : 0);
        return result;
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
