package ru.javawebinar.topjava.service;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import ru.javawebinar.topjava.UserTestData;
import ru.javawebinar.topjava.model.Role;
import ru.javawebinar.topjava.model.User;
import ru.javawebinar.topjava.util.DbPopulator;
import ru.javawebinar.topjava.util.exception.NotFoundException;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;


import static ru.javawebinar.topjava.UserTestData.*;

/**
 * Created by Александр on 2017-04-26.
 */

@ContextConfiguration({
        "classpath:spring/spring-app.xml",
        "classpath:spring/spring-db.xml"
})
@RunWith(SpringJUnit4ClassRunner.class)
public class UserServiceTest {

    @Autowired
    protected UserService service;
    @Autowired
    private DbPopulator dbPopulator;

    @Before
    public void setUp() throws Exception {
        dbPopulator.execute();
    }

    @Test
    public void testSave() throws Exception {
        TestUser testUser = new TestUser(null, "New", "new@gmail.com", "newPass", 1700, false, Collections.singleton(Role.ROLE_USER));
        User createdUser = service.save(testUser.asUser());
        testUser.setId(createdUser.getId());
        MATCHER.assertCollectionEquals(Arrays.asList(ADMIN, testUser, USER), service.getAll());
    }


}