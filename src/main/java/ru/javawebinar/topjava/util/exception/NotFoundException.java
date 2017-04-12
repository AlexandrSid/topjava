package ru.javawebinar.topjava.util.exception;

/**
 * Created by Александр on 2017-04-12.
 */
public class NotFoundException extends RuntimeException{
    public NotFoundException(String message) {
        super(message);
    }
}
