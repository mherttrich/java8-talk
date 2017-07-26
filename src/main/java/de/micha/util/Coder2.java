package de.micha.util;

import com.google.common.collect.ImmutableSet;

import java.util.Set;

/**
 * Created by mherttrich on 26/07/17.
 */
public final class Coder2 {

    private final String firstname;
    private final String lastname;
    private final ImmutableSet<String> skills;




    private Coder2(Builder builder) {
        this.firstname = builder.firstName;
        this.lastname = builder.lastName;
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Coder2 coder = (Coder2) o;

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
        return "Coder2{" +
                "firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", skills=" + skills +
                '}';
    }

    public static class Builder{

        private String firstName;
        private String lastName;
        private Set<String> skills;
        public Builder() {
        }
        public Builder addFirstName(String fn){
            this.firstName = fn;
            return this;
        }
        public Builder addLastName(String ln){
            this.lastName = ln;
            return this;
        }
        public Builder addSkills(Set<String> skills){
            this.skills = skills;
            return this;
        }
        public Coder2 build(){
            return new Coder2(this);
        }
    }
}
