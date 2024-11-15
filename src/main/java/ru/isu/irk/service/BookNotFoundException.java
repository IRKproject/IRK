
package ru.isu.irk.service;


public class BookNotFoundException extends RuntimeException{
    public BookNotFoundException(String message) {
        super(message);
    }       
}
