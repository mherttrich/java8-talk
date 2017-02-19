package de.domain;


import java.util.Optional;
import java.util.Set;

/**
 * Created by mherttrich on 19.06.15.
 */


public class Person {

    private String name= "default person";;
    private Gender gender = Gender.FEMALE;
    private Integer height =0;
    private int age=0;
    private Optional<Adress> adress = Optional.empty();
    private Set<String> languages;

    public Person(){
    }

    public Person(String name, Gender gender, Integer height, int age) {
        this.name = name;
        this.gender = gender;
        this.height = height;
        this.age = age;
    }

    public Person(String name, Gender gender, int height, int age, Set<String> languages) {
        this(name, gender, height, age);
        this.languages = languages;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Optional<Adress> getAdress() {
        return adress;
    }

    public void setAdress(Adress adress) {
        this.adress = Optional.ofNullable(adress);
    }


    public Set<String> getLanguages() {
        return languages;
    }

    public void setLanguages(Set<String> languages) {
        this.languages = languages;
    }

    public enum Gender{
        MALE,
        FEMALE
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", gender=" + gender +
                ", height=" + height +
                ", age=" + age +
                '}';
    }

    public boolean isTall(){
        return this.getHeight() > 170;
    }
}
