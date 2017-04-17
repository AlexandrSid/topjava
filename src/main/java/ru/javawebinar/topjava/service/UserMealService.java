package ru.javawebinar.topjava.service;

import ru.javawebinar.topjava.model.UserMeal;
import ru.javawebinar.topjava.util.exception.NotFoundException;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Collection;

/**
 * Created by Александр on 2017-04-12.
 */
public interface UserMealService {

    UserMeal get(int id, int userId) throws NotFoundException;

    void delete(int id, int userId) throws NotFoundException;

    default Collection<UserMeal> getBetweenDates(LocalDate startDate, LocalDate endDate, int userId) {
        return getBetweenDateTime(LocalDateTime.of(startDate, LocalTime.MIN), LocalDateTime.of(endDate, LocalTime.MAX), userId);
    }

    Collection<UserMeal> getBetweenDateTime(LocalDateTime start, LocalDateTime end, int userId);

    Collection<UserMeal> getAll(int userId);

    UserMeal update(UserMeal userMeal, int userId) throws NotFoundException;

    UserMeal save(UserMeal userMeal, int userId);

}
