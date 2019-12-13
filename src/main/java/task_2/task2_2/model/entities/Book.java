package task_2.task2_2.model.entities;

import java.math.BigDecimal;
import java.util.Comparator;

public class Book {
    private String title;
    private String author;
    private String publisher;
    private int yearOfPublish;
    private int amountOfPages;
    private BigDecimal price;

    public static BookPublisherComparator getBookPublisherComparator(){
        return new BookPublisherComparator();
    }

    public Book(String title, String author, String publisher, int yearOfPublish, int amountOfPages, BigDecimal price) {
        this.title = title;
        this.author = author;
        this.publisher = publisher;
        this.yearOfPublish = yearOfPublish;
        this.amountOfPages = amountOfPages;
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public int getYearOfPublish() {
        return yearOfPublish;
    }

    public void setYearOfPublish(int yearOfPublish) {
        this.yearOfPublish = yearOfPublish;
    }

    public int getAmountOfPages() {
        return amountOfPages;
    }

    public void setAmountOfPages(int amountOfPages) {
        this.amountOfPages = amountOfPages;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }



    @Override
    public String toString() {
        return getClass().getSimpleName()+"{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", publisher='" + publisher + '\'' +
                ", yearOfPublish=" + yearOfPublish +
                ", amountOfPages=" + amountOfPages +
                ", price=" + price +
                "}\n";
    }

    private static class BookPublisherComparator implements Comparator{
        public int compare(Object o1, Object o2) {
            Book b1 = (Book) o1;
            Book b2 = (Book) o2;
            return b1.publisher.hashCode() - b2.publisher.hashCode();
        }
    }
}
