package task_2.task2_2.Controller;

import task_2.task2_2.View.BookView;
import task_2.task2_2.Model.Entities.Book;
import task_2.task2_2.Model.BookModel;

import java.math.BigDecimal;
import java.util.Random;
import java.util.Scanner;

public class BookController {

    private BookModel bookModel;
    private BookView bookView;
    private Random random = new Random();
    private String[] authors, publishers;
    private int[] yearsOfPublish;


    public BookController(int booksAmount,
                          String[] titles,
                          String[] authors,
                          String[] publishers,
                          int[] yearsOfPublish,
                          int[] pagesAmounts,
                          BigDecimal[] prices){

        this.authors = authors;
        this.publishers = publishers;
        this.yearsOfPublish = yearsOfPublish;

        Book[] books = parseData(booksAmount, titles,authors,publishers,yearsOfPublish,pagesAmounts,prices);

        bookModel = new BookModel(books);
        bookView = new BookView();


    }

    public void startDialog(){
        bookView.printMenu();
        doDialog();
    }

    private int pickRandom(int bounds){
        return random.nextInt(bounds);
    }

    private Book[] parseData(int booksAmount,
                             String[] titles,
                             String[] authors,
                             String[] publishers,
                             int[] yearsOfPublish,
                             int[] pagesAmounts,
                             BigDecimal[] prices){

        Book[] books = new Book[booksAmount];
        for (int i = 0; i < booksAmount; i++){
            String title = titles[pickRandom(titles.length)];
            String author = authors[pickRandom(authors.length)];
            String publisher = publishers[pickRandom(publishers.length)];
            int yearOfPublish = yearsOfPublish[pickRandom(yearsOfPublish.length)];
            int pagesAmount = pagesAmounts[pickRandom(pagesAmounts.length)];
            BigDecimal price = prices[pickRandom(prices.length)];

            books[i] = new Book(title, author, publisher, yearOfPublish, pagesAmount, price);
        }
        return books;
    }

    private void doDialog(){
        bookView.printMessage("\n\t Input data: \n", bookModel.getBooksRepresentation());
        Scanner scanner = new Scanner(System.in);
        dialog:
        while (true){
            int i = scanner.nextInt();
            switch (i){
                case 0:
                    break dialog;
                case 1:
                    String author = authors[pickRandom(authors.length)];
                    bookView.printMessage(BookView.AUTHOR_TEXT, author,  bookModel.getBooksByAuthor(author));
                    break;
                case 2:
                    String publisher = publishers[pickRandom(publishers.length)];
                    bookView.printMessage(BookView.PUBLISHER_TEXT, publisher, bookModel.getBooksByPublisher(publisher));
                    break;
                case 3:
                    int year = yearsOfPublish[pickRandom(yearsOfPublish.length)];
                    bookView.printMessage(BookView.YEAR_TEXT, year, bookModel.getBooksPublishedLaterThan(year));
                    break;
                case 4:
                    bookView.printMessage(BookView.SORT_TEXT, bookModel.sortByPublisher());
                    break;
                default:
                    bookView.printMessage(BookView.ERROR_TEXT,"");
                    break;
            }
        }
    }

    /*
        bookView.printMessage("", bookModel.getBooksByAuthor(authors[pickRandom(authors.length)]));
        bookView.printMessage("", bookModel.getBooksByPublisher(publishers[pickRandom(publishers.length)]));
        bookView.printMessage("", bookModel.getBooksPublishedLaterThan(yearsOfPublish[pickRandom(yearsOfPublish.length)]));
        bookView.printMessage("", bookModel.sortByPublisher());
     */
}
