package models;

public class Person {
    private int age;
    private String name;

    @Override
    public String toString() {
        return "Persona [age=" + age + ", name=" + name + "]";
    }

    public Person(int age, String name) {
        this.age = age;
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int code) {
        this.age = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
