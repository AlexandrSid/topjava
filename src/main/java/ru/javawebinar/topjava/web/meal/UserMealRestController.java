package ru.javawebinar.topjava.web.meal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import ru.javawebinar.topjava.LoggedUser;
import ru.javawebinar.topjava.model.UserMeal;
import ru.javawebinar.topjava.service.UserMealService;
import ru.javawebinar.topjava.to.UserMealWithExceed;
import ru.javawebinar.topjava.util.TimeUtil;
import ru.javawebinar.topjava.util.UserMealsUtil;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

/**
 * Created by Александр on 2017-04-13.
 */
@Controller
public class UserMealRestController {
    protected final Logger LOG = LoggerFactory.getLogger(getClass());
    @Autowired
    private UserMealService service;

    public UserMeal create(UserMeal userMeal) {
//        userMeal.setId(null);
        int userId = LoggedUser.id();
        LOG.info("Create UserMeal  {}  for user id = {}", userMeal, userId);
        return service.save(userMeal, userId);
    }

    public void update(UserMeal userMeal, int id) {
        userMeal.setId(id);
        int userId = LoggedUser.id();
        LOG.info("Update meal {} for user {}", userMeal, userId);
        service.save(userMeal, userId);
    }

    public void delete(int id) {
        int userId = LoggedUser.id();
        LOG.info("Deleting meal {} for user {}", id, userId);
        service.delete(id, userId);
    }

    public UserMeal get(int id) {
        int userId = LoggedUser.id();
        LOG.info("Getting meal {} for user {}", id, userId);
        return service.get(id, userId);
    }

    public List<UserMealWithExceed> getAll() {
        int userID = LoggedUser.id();
        LOG.info("Getting all for user [}", userID);
        return UserMealsUtil.getWithExceeded(service.getAll(userID), LoggedUser.getCaloriesPerDay());
    }

    public List<UserMealWithExceed> getBetween(LocalDate startDate, LocalTime startTime, LocalDate endDate, LocalTime endTime) {
        int userId = LoggedUser.id();
        LOG.info("Gettin between {} -{} and {} = {} for User {}", startDate, startTime, endDate, endTime, userId);
        return UserMealsUtil.getFilteredWithExceeded(
                service.getBetweenDates(
                        startDate != null ? startDate : TimeUtil.MIN_DATE,
                        endDate != null ? endDate : TimeUtil.MAX_DATE,
                        userId),
                startTime != null ? startTime : LocalTime.MIN, endTime != null ? endTime : LocalTime.MAX,
                LoggedUser.getCaloriesPerDay()
        );
    }
}
