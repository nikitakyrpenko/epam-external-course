package task_2.task2_2;

import task_2.task2_2.Controller.BookController;



public class Main {
    public static void main(String... args){



        BookController bookController = new BookController(10,
                Data.titles,
                Data.authors,
                Data.publishers,
                Data.yearsOfPublish,
                Data.pagesAmounts,
                Data.prices);

        bookController.startDialog();



    }
}
