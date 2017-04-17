package ru.javawebinar.topjava.repository.mock;

import org.springframework.stereotype.Repository;
import ru.javawebinar.topjava.model.UserMeal;
import ru.javawebinar.topjava.repository.UserMealRepository;
import ru.javawebinar.topjava.util.TimeUtil;
import ru.javawebinar.topjava.util.UserMealsUtil;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.Comparator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

import static ru.javawebinar.topjava.repository.mock.InMemoryUserRepositoryImpl.ADMIN_ID;
import static ru.javawebinar.topjava.repository.mock.InMemoryUserRepositoryImpl.USER_ID;

/**
 * Created by Александр on 2017-04-07.
 */
@Repository
public class InMemeoryUserMealRepositoryImpl implements UserMealRepository {
    //sorting by time. last records upwards
    public  static final Comparator<UserMeal> USER_MEAL_COMPARATOR = Comparator.comparing(UserMeal::getDateTime).reversed();

    private Map<Integer, Map<Integer, UserMeal>> repository = new ConcurrentHashMap<>();
    private AtomicInteger counter = new AtomicInteger(0);

    {
        UserMealsUtil.MEAL_LIST.forEach(um -> save(um, USER_ID));

        save(new UserMeal(10, LocalDateTime.now(), "Admin's lunch", 1000), ADMIN_ID);
        save(new UserMeal(11, LocalDateTime.now(), "Admin's dinner", 1100), ADMIN_ID);
    }


    @Override
    public UserMeal save(UserMeal userMeal, int userId) {
        if (userMeal.isNew()) {
            userMeal.setId(counter.incrementAndGet());
        } else if (get(userMeal.getId(), userId) == null) {
            return null;
        }
        Map<Integer, UserMeal> userMeals = repository.getOrDefault(userId, new ConcurrentHashMap<>());
        userMeals.put(userMeal.getId(), userMeal);
        repository.put(userId, userMeals);
        return userMeal;
    }

    @Override
    // false if meal do not belong to userId
    public boolean delete(int id, int userId) {
        Map<Integer, UserMeal> userMeals = repository.get(userId);
        return userMeals != null && userMeals.remove(id) != null;
    }

    @Override
    public UserMeal get(int id, int userId) {
        Map<Integer, UserMeal> userMeals = repository.get(userId);
        return userMeals == null ? null : userMeals.get(id);
    }

    @Override
    public Collection<UserMeal> getAll(int userId) {
        Map<Integer, UserMeal> userMeals = repository.get(userId);
        if (userMeals == null) {
            userMeals = new ConcurrentHashMap<>();
            return userMeals.values();
        }
        return userMeals.values().stream().sorted(USER_MEAL_COMPARATOR).collect(Collectors.toList());
    }

    @Override
    public Collection<UserMeal> getBetween(LocalDateTime startTime, LocalDateTime endTime, int userId) {
        Map<Integer, UserMeal> userMeals = repository.get(userId);
        if (userMeals == null) {
            userMeals = new ConcurrentHashMap<>();
            return userMeals.values();
        }
        return userMeals.values()
                .stream()
                .filter(um -> TimeUtil.isBetween(um.getDateTime(), startTime, endTime))
                .sorted(USER_MEAL_COMPARATOR)
                .collect(Collectors.toList());
    }
}
