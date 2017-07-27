package de.micha.domain;

import com.google.common.collect.ImmutableSet;

import java.util.Set;

/**
 * Created by mherttrich on 26/07/17.
 */
public final class Coder {

    private final String firstname;
    private final String lastname;
    private final Set<String> skills;



    public Coder(Builder b) {
        this.firstname = b.firstname;
        this.lastname = b.lastname;
        //someone still holding a refrence to skills might change it from outside
        this.skills = ImmutableSet.copyOf(b.skills);
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }


    public Set<String> getSkills() {
        // return a clone or a immutable
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

        private String firstname;
        private String lastname;
        private Set<String> skills;

        // mandatory field
        public Builder(String firstname) {
            this.firstname = firstname;
        }

        // optionally field
        public Builder addLastname(String lastname) {
            this.lastname = lastname;
            return this;
        }

        // optionally field
        public Builder addSkills(Set<String> skills) {
            this.skills = skills;
            return this;
        }

        public Coder build() {
            return new Coder(this);
        }
    }
}
