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
//    public String getFirstName() {
//        return firstName;
//    }
//
//    public void setFirstName(String firstName) {
//        this.firstName = firstName;
//    }
//
//    public String getLastName() {
//        return lastName;
//    }
//
//    public void setLastName(String lastName) {
//        this.lastName = lastName;
//    }

    //other methods
    public String getAuthorFullName() {
        return firstName + " " + lastName;
    }

    public void printAuthorFullName() {
        System.out.printf("Author's full name: %s %s%n", firstName, lastName);
    }

}

