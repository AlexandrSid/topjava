package ru.javawebinar.topjava.util.exception;

import java.util.Objects;

/**
 * Created by Александр on 2017-04-12.
 */
public class ExceptionUtil {

    public static void check(boolean found, String message){
        if(!found) throw new NotFoundException("Not found entity with " + message);
    }

    public static void check(boolean found, int id){
        check(found, "id = " + id);
    }

    public static <T> T check(T object, String message){
        check(object != null, message);
        return object;
    }

    public static <T> T check(T object, int id){
        return check(object, "id = " + id);
    }
}
