package ru.javawebinar.topjava.service;

import ru.javawebinar.topjava.repository.UserMealRepository;

/**
 * Created by Александр on 2017-04-12.
 */
public class UserMealServiceImpl implements UserMealService {
    public void setRepository(UserMealRepository repository) {
        this.repository = repository;
    }

    private UserMealRepository repository;
}
