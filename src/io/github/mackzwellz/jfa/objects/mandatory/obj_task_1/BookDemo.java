package io.github.mackzwellz.jfa.objects.mandatory.obj_task_1;

import io.github.mackzwellz.jfa.objects.mandatory.obj_task_1.models.Author;
import io.github.mackzwellz.jfa.objects.mandatory.obj_task_1.models.Book;

public class BookDemo {

    public static void main(String[] args) {
        Author author = new Author("Russel", "Winder");
        author.printAuthorFullName();
        Book book = new Book("Developing Java Software", author, 79.75);
        book.printBookDetails();
    }

}
