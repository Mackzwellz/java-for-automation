package io.github.mackzwellz.jfa.objects.mandatory.obj_task_1.models;

public class Author {

    //fields
    private String firstName;
    private String lastName;

    //constructor
    public Author(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    //getters and setters for fields
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    //other methods
    @Override
    public String toString() {
        return firstName + " " + lastName;
    }

    public void printAuthorFullName() {
        System.out.println("Author's full name: " + this);
    }

}