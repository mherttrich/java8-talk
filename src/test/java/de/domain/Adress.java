package de.domain;

import java.util.Optional;

/**
 * Created by micha on 13.02.17.
 */
public class Adress {

    Adress(){
    }

    public Adress(String street, City city) {
        //only use Optional.of(  if U R sure, its not null
        this.street = Optional.ofNullable(street);
        this.city = Optional.ofNullable(city);
    }

    private Optional<String> street = Optional.empty();
    private Optional<City> city = Optional.empty();

    public Optional<String> getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = Optional.ofNullable(street);
    }


    public Optional<City> getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = Optional.ofNullable(city);
    }

}
