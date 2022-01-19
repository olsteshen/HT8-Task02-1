package com.example.java;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import org.apache.commons.lang3.RandomStringUtils;

public class Book {
    private String name;
    private Integer price;

    public Book() {
        Random random = new Random();
        name = RandomStringUtils.randomAlphabetic(3, 11);
        price = random.nextInt(99);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public List<Book> createListOfBooks(int numberOfBooks) {
        List<Book> listOfBooks = new ArrayList<>();
        for (int i = 0; i < numberOfBooks; i++) {
            listOfBooks.add(new Book());
        }
        return listOfBooks;
    }

    // get List<String> of all book names and print them
    public void getBooksNames(List<Book> books) {
        List<Book> bookList = new ArrayList<>(books);
        List<String> booksNames = bookList
                .stream()
                .map(book -> book.getName())
                .collect(Collectors.toList());
        System.out.println("Names of all books:" + booksNames);
    }

    //get total price of all books and print it
    public void getTotalPrice(List<Book> books) {
        List<Book> bookList = new ArrayList<>(books);
        Integer totalPrice = bookList
                .stream()
                .map((book) -> book.price)
                .reduce(0, (acc, x) -> acc + x);
        System.out.println("Total price of all books: " + totalPrice);
    }

    //get any book with “A” or “a” character in name and print its name
    public void getBooksWithA(List<Book> books) {
        List<Book> bookList = new ArrayList<>(books);
        List<String> booksWithA = bookList
                .stream()
                .map((book) -> book.name)
                .filter((book) -> book.toLowerCase().contains("a"))
                .collect(Collectors.toList());
        System.out.println("Books with a in the name: " + booksWithA);
    }

    //print book name with the highest price
    public void getHighestPricedBook(List<Book> books) {
        List<Book> bookList = new ArrayList<Book>(books);
        Book expensiveBook = bookList
                .stream()
                .max(Comparator.comparing(Book::getPrice))
                .get();
        System.out.println("Book with the highest price: " + expensiveBook);
    }

    //get number of books where name consists of 5 letters
    public void getNumberOfBooksWith5Letters(List<Book> books) {
        List<Book> bookList = new ArrayList<>(books);
        Predicate<String> is5Letters = (str) -> str.length() == 5;
        Long numberOfBooksWith5Letters = bookList
                .stream()
                .map((book) -> book.name)
                .filter(is5Letters)
                .count();
        System.out.println("Number of books with 5 letters in the name: " + numberOfBooksWith5Letters);
    }

    //get all books except books with price higher then 30
    public void getBooksCheaperThan30(List<Book> books) {
        List<Book> bookList = new ArrayList<>(books);
        List<Book> booksCheaperThan5 = bookList
                .stream()
                .filter((book) -> book.price < 30)
                .collect(Collectors.toList());
        System.out.println("Books cheaper than 30: " + booksCheaperThan5);
    }

    //sort books by name in desc order, if name equals then sort by price
    public void sortBooksByName(List<Book> books) {
        List<Book> bookList = new ArrayList<>(books);
        List<String> sortedList = bookList
                .stream()
                .map((book) -> book.name.toUpperCase())
                .sorted()
                .collect(Collectors.toList());
        System.out.println("Sorted list of books: " + sortedList);
    }

    @Override
    public String toString() {
        return "name:" + name +
                ", price:" + price;
    }

}