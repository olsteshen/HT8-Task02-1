package com.example.java;


import java.util.List;

public class Main {

    public static void main(String[] args) {
        Book book = new Book();
        List<Book> listOfBooks = book.createListOfBooks(5);
        System.out.println("Print all books: " + listOfBooks.toString());
        book.getBooksNames(listOfBooks);
        book.getTotalPrice(listOfBooks);
        book.getBooksWithA(listOfBooks);
        book.getHighestPricedBook(listOfBooks);
        book.getNumberOfBooksWith5Letters(listOfBooks);
        book.getBooksCheaperThan30(listOfBooks);
        book.sortBooksByName(listOfBooks);

    }
}
