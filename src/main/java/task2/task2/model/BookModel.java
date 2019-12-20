package task2.task2.model;

import task2.task2.model.entities.Book;

import java.util.Arrays;
import java.util.Comparator;

public class BookModel<T extends Book> {
    private T[] books;

    public BookModel(T[] books){
        this.books = books;
    }

    public T[] getBooks() { return books; }

    public Book[] getBooksByAuthor(String author){
        int count = 0;
        for (Book book : books)
            if (book.getAuthor().equals(author))
                count = count + 1;

        Book[] result = new Book[count];
        int innerCount = 0;
        for (Book book : books)
            if (book.getAuthor().equals(author))
                result[innerCount++] = book;


        return result;
    }

    public Book[] getBooksByPublisher(String publisher){
        int count = 0;
        for (Book book : books)
            if (book.getPublisher().equals(publisher))
                count = count + 1;

        Book[] result = new Book[count];
        int innerCount = 0;
        for (Book book : books)
           if (book.getPublisher().equals(publisher))
               result[innerCount++] = book;


       return result;
    }

    public Book[] getBooksPublishedLaterThan(int bound){
        int count = 0;
        for (Book book : books)
            if (book.getYearOfPublish() > bound)
                count = count + 1;

        Book[] result = new Book[count];
        int innerCount = 0;
        for (Book book : books)
            if (book.getYearOfPublish() > bound)
                result[innerCount++] = book;


        return result;
    }

    public Book[] sortByPublisher(){
        Book[] copyOfBooks = Arrays.copyOf(books,books.length);
        Arrays.sort(copyOfBooks, new Comparator<Book>() {
            @Override
            public int compare(Book o1, Book o2) {
                return o1.getPublisher().hashCode() - o2.getPublisher().hashCode();
            }
        });
        return copyOfBooks;
    }



}
