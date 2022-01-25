package com.example.java;


import java.util.*;

public class Main {

    public static void main(String[] args) {
        //subtask 1
        Book book = new Book();
        List<Book> listOfBooksRandom = book.createListOfBooks(5);
        System.out.println('\n'+ "Print all random books: " + listOfBooksRandom.toString());
        book.getBooksNames(listOfBooksRandom);
        book.getTotalPrice(listOfBooksRandom);
        book.getBooksWithA(listOfBooksRandom);
        book.getHighestPricedBook(listOfBooksRandom);
        book.getNumberOfBooksWith5Letters(listOfBooksRandom);
        book.getBooksCheaperThan30(listOfBooksRandom);
        book.sortBooksByName(listOfBooksRandom);
    }
}
