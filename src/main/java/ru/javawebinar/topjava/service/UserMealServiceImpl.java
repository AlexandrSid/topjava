package ru.javawebinar.topjava.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.javawebinar.topjava.model.UserMeal;
import ru.javawebinar.topjava.repository.UserMealRepository;
import ru.javawebinar.topjava.util.exception.ExceptionUtil;
import ru.javawebinar.topjava.util.exception.NotFoundException;

import java.time.LocalDateTime;
import java.util.Collection;

/**
 * Created by Александр on 2017-04-12.
 */
@Service
public class UserMealServiceImpl implements UserMealService {
    public void setRepository(UserMealRepository repository) {
        this.repository = repository;
    }

    @Autowired
    private UserMealRepository repository;

    @Override
    public UserMeal get(int id, int userId) throws NotFoundException {
        UserMeal userMeal = repository.get(id, userId);
        return ExceptionUtil.check(repository.get(id, userId), id);
    }

    @Override
    public void delete(int id, int userId) throws NotFoundException {
        ExceptionUtil.check(repository.delete(id, userId), id);
    }

    @Override
    public Collection<UserMeal> getBetweenDateTime(LocalDateTime start, LocalDateTime end, int userId) {
        return repository.getBetween(start, end, userId
        );
    }

    @Override
    public Collection<UserMeal> getAll(int userId) {
        return repository.getAll(userId);
    }

    @Override
    public UserMeal update(UserMeal userMeal, int userId) {
        return ExceptionUtil.check(repository.save(userMeal, userId), userMeal.getId());
    }

    @Override
    public UserMeal save(UserMeal userMeal, int userId) {
        return repository.save(userMeal, userId);
    }


}
