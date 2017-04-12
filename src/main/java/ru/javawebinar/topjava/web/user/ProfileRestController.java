package ru.javawebinar.topjava.web.user;

import org.springframework.stereotype.Controller;
import ru.javawebinar.topjava.model.User;

/**
 * Created by Александр on 2017-04-13.
 */
@Controller
public class ProfileRestController extends AbstractUserController {
    @Override
    public User get(int id) {
        return super.get(id);
    }

    @Override
    public void delete(int id) {
        super.delete(id);
    }

    @Override
    public void update(User user, int id) {
        super.update(user, id);
    }
}
