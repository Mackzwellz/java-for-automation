package io.github.mackzwellz.jfa.objects.mandatory.obj_task_1.models;

public class Book {

    //fields
    private String title;
    private Author author;
    private double price;

    //constructor
    public Book(String title, Author author, double price) {
        this.title = title;
        this.author = author;
        this.price = price;
    }

//    getters and setters for fields
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    //other methods
    public void printBookDetails() {
        System.out.printf("Book details: title='%s', author='%s', price='%s'%n", title, author, price);
    }
}