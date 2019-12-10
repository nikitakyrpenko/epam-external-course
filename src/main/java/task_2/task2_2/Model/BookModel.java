package task_2.task2_2.Model;

import task_2.task2_2.Model.Entities.Book;

import java.util.Arrays;

public class BookModel {
    private Book[] books;

    public BookModel(Book[] books){
        this.books = books;
    }

    public String getBooksRepresentation(){
        return Arrays.toString(books);
    }

    public String getBooksByAuthor(String author){
        String result = "";
        for(Book book : books)
            if (book.getAuthor() == author)
                result = result + book;
        if (result.isEmpty())
            return "None was found";
        return result;
    }

    public String getBooksByPublisher(String publisher){
        String result = "";
        for (Book book : books)
            if (book.getPublisher() == publisher)
                result = result + book;
        if (result.isEmpty())
            return "None was found";
        return result;
    }

    public String getBooksPublishedLaterThan(int bound){
        String result = "";
        for (Book book : books)
            if (book.getYearOfPublish() > bound)
                result = result + book;
        if (result.isEmpty())
            return "None was found";
        return result;
    }

    public String sortByPublisher(){
        Book[] copyOfBooks = Arrays.copyOf(books,books.length);
        Arrays.sort(copyOfBooks, Book.getBookPublisherComparator());
        return "\tInitial books: \n" + Arrays.toString(books) + "\tSorted by publisher: \n" + Arrays.toString(copyOfBooks);

    }

}
