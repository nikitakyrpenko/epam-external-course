package task2.task2_2.model;

import task2.task2_2.model.entities.Book;

import java.util.Arrays;

public class BookModel {
    private Book[] books;

    public BookModel(Book[] books){
        this.books = books;
    }

    public Book[] getBooks() { return books; }

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
        Arrays.sort(copyOfBooks, Book.getBookPublisherComparator());
        return copyOfBooks;
    }



}
