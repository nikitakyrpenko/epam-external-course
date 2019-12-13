package task_2.task2_2.controller;

import task_2.task2_2.model.entities.Book;
import task_2.task2_2.utils.Utils;

import java.math.BigDecimal;

public class BookParser {

    public static Book[] parseData(int booksAmount,
                                    String[] titles,
                                    String[] authors,
                                    String[] publishers,
                                    int[] yearsOfPublish,
                                    int[] pagesAmounts,
                                    BigDecimal[] prices){

        Book[] books = new Book[booksAmount];
        for (int i = 0; i < booksAmount; i++){
            String title = titles[Utils.pickRandom(titles.length)];
            String author = authors[Utils.pickRandom(authors.length)];
            String publisher = publishers[Utils.pickRandom(publishers.length)];
            int yearOfPublish = yearsOfPublish[Utils.pickRandom(yearsOfPublish.length)];
            int pagesAmount = pagesAmounts[Utils.pickRandom(pagesAmounts.length)];
            BigDecimal price = prices[Utils.pickRandom(prices.length)];

            books[i] = new Book(title, author, publisher, yearOfPublish, pagesAmount, price);
        }
        return books;
    }
}
