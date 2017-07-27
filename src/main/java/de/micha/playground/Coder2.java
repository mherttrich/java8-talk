package de.micha.playground;

import com.google.common.collect.ImmutableSet;

import java.util.Set;

/**
 * Created by mherttrich on 26/07/17.
 */
public final class Coder2 {

    private String firstname;
    private String lastname;
    private Set<String> skills;




    private Coder2(Builder builder) {
        this.firstname = builder.firstname;
        this.lastname = builder.lastname;
        this.skills = ImmutableSet.copyOf(builder.skills);
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

    public static class Builder {

        public Builder(String firstname) {
            this.firstname = firstname;
        }


        public Builder addLastname(String lastname) {
            this.lastname = lastname;
            return this;
        }

        public Builder addSkills(Set<String> skills) {
            this.skills = skills;
            return this;
        }
        public Coder2 build(){
            return new Coder2(this);
        }

        private String firstname;
        private String lastname;
        private Set<String> skills;

    }
}
