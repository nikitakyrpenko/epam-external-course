package task_2.task2_2.controller;

import task_2.task2_2.utils.Utils;
import task_2.task2_2.view.BookView;
import task_2.task2_2.model.entities.Book;
import task_2.task2_2.model.BookModel;

import java.math.BigDecimal;

public class BookController {

    private BookModel bookModel;
    private BookView bookView;
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

        Book[] books = BookParser.parseData(booksAmount, titles,authors,publishers,yearsOfPublish,pagesAmounts,prices);

        bookModel = new BookModel(books);
        bookView = new BookView();


    }

    public void startDialog(){
        bookView.printMenu();
        doDialog();
    }





    private void doDialog(){
        bookView.printMessage("\n\t Input data: \n", Utils.arrayToString(bookModel.getBooks()));
        dialog:
        while (true){
            int i = Utils.input();
            switch (i){
                case 0:
                    break dialog;
                case 1:
                    String author = authors[Utils.pickRandom(authors.length)];
                    bookView.printMessage(BookView.AUTHOR_TEXT, author,  Utils.arrayToString(bookModel.getBooksByAuthor(author)));
                    break;
                case 2:
                    String publisher = publishers[Utils.pickRandom(publishers.length)];
                    bookView.printMessage(BookView.PUBLISHER_TEXT, publisher, Utils.arrayToString(bookModel.getBooksByPublisher(publisher)));
                    break;
                case 3:
                    int year = yearsOfPublish[Utils.pickRandom(yearsOfPublish.length)];
                    bookView.printMessage(BookView.YEAR_TEXT, year, Utils.arrayToString(bookModel.getBooksPublishedLaterThan(year)));
                    break;
                case 4:
                    bookView.printMessage(BookView.SORT_TEXT, Utils.arrayToString(bookModel.sortByPublisher()));
                    break;
                default:
                    bookView.printMessage(BookView.ERROR_TEXT,"");
                    break;
            }
        }
    }


}
