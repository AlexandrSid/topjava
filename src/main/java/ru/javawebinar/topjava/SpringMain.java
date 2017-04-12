package ru.javawebinar.topjava;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.javawebinar.topjava.model.Role;
import ru.javawebinar.topjava.model.User;
import ru.javawebinar.topjava.web.user.AdminRestController;

import java.util.Arrays;

/**
 * Created by Александр on 2017-04-13.
 */
public class SpringMain {
    public static void main(String[] args) {
/*        ConfigurableApplicationContext appCtx = new ClassPathXmlApplicationContext("spring/spring-app.xml");
        System.out.println("!!!!!" + Arrays.toString(appCtx.getBeanDefinitionNames()));

//        UserRepository userRepository = (UserRepository) appCtx.getBean("UserRepository");
        UserRepository userRepository = appCtx.getBean(UserRepository.class);
        userRepository.getAll();

        UserService userService = appCtx.getBean(UserService.class);
        System.out.println("!!!!! " + userService.save(new User(1, "userName", "email", "password", Role.ROLE_ADMIN)));

        appCtx.close();*/

        try (ConfigurableApplicationContext appCtx = new ClassPathXmlApplicationContext("spring/spring-app.xml")) {
            System.out.println(Arrays.toString(appCtx.getBeanDefinitionNames()));
            AdminRestController adminRestController = appCtx.getBean(AdminRestController.class);
            System.out.println(adminRestController.create(new User(1, "userName", "email", "password", Role.ROLE_ADMIN)));
        }
    }
}
