package ru.javawebinar.topjava.web;

import org.junit.*;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.javawebinar.topjava.model.User;
import ru.javawebinar.topjava.repository.UserRepository;
import ru.javawebinar.topjava.util.exception.NotFoundException;
import ru.javawebinar.topjava.web.user.AdminRestController;

import java.util.Arrays;
import java.util.List;

import static ru.javawebinar.topjava.UserTestData.*;

/**
 * Created by Александр on 2017-04-21.
 */
public class InMemoryAdminRestControllerTest {
    public static ConfigurableApplicationContext appCtx;
    public static AdminRestController controller;

    @BeforeClass
    public static void beforeClass() {
        appCtx = new ClassPathXmlApplicationContext("spring/spring-app.xml");
        System.out.println("\n" + Arrays.toString(appCtx.getBeanDefinitionNames()) + "\n");
        controller = appCtx.getBean(AdminRestController.class);
    }

    @Before
    public void setUp() {
        UserRepository repository = appCtx.getBean(UserRepository.class);
        repository.getAll().forEach(user -> repository.delete(user.getId()));
        repository.save(ADMIN);
        repository.save(USER);
    }

    @AfterClass
    public static void afterClass() {
        appCtx.close();
    }

    @Test
    public void testDelete(){
        controller.delete(USER_ID);
        List<User> users = controller.getAll();
        Assert.assertEquals(users.size(), 1);
        Assert.assertEquals(users.iterator().next(), ADMIN);
    }

    @Test(expected = NotFoundException.class)
//    @Test
    public void testDeleteNotFound() throws Exception{
        controller.delete(10);
    }
}
