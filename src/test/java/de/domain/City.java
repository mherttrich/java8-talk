package de.domain;

import java.util.Optional;

/**
 * Created by micha on 14.02.17.
 */
public class City {

    Optional<String> zipCode;

    public City(String zipCode) {
        this.zipCode = Optional.ofNullable(zipCode);
    }

    public Optional<String> getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = Optional.ofNullable(zipCode);
    }
}
