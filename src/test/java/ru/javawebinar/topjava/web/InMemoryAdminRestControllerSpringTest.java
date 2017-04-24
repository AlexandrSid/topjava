package ru.javawebinar.topjava.web;

import org.junit.*;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import ru.javawebinar.topjava.model.User;
import ru.javawebinar.topjava.repository.UserRepository;
import ru.javawebinar.topjava.util.exception.NotFoundException;
import ru.javawebinar.topjava.web.user.AdminRestController;

import java.util.List;

import static ru.javawebinar.topjava.UserTestData.ADMIN;
import static ru.javawebinar.topjava.UserTestData.USER;
import static ru.javawebinar.topjava.UserTestData.USER_ID;

/**
 * Created by Александр on 2017-04-24.
 */
@ContextConfiguration("classpath:spring/spring-app.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class InMemoryAdminRestControllerSpringTest {
    @Autowired
    public static AdminRestController controller;

    @Autowired
    public static UserRepository repository;

    @Before
    public void setUp() {
        repository.getAll().forEach(user -> repository.delete(user.getId()));
        repository.save(ADMIN);
        repository.save(USER);
    }

    @Test
    public void testDelete() {
        controller.delete(USER_ID);
        List<User> users = controller.getAll();
        Assert.assertEquals(users.size(), 1);
        Assert.assertEquals(users.iterator().next(), ADMIN);
    }

    @Test(expected = NotFoundException.class)
    public void testDeleteNotFound() throws Exception {
        controller.delete(10);
    }

}
