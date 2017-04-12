package ru.javawebinar.topjava.repository.mock;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import ru.javawebinar.topjava.model.User;
import ru.javawebinar.topjava.repository.UserRepository;

import java.util.List;

/**
 * Created by Александр on 2017-04-13.
 */
@Repository
public class MockUserRepositoryImpl implements UserRepository {
    private static final Logger LOG = LoggerFactory.getLogger(MockUserRepositoryImpl.class);

    @Override
    public User save(User user) {
        LOG.info("mock safe " + user);
        return null;
    }

    @Override
    public boolean delete(int id) {
        LOG.info("mock delete " + id);
        return false;
    }

    @Override
    public User get(int id) {
        LOG.info("mock get " + id);
        return null;
    }

    @Override
    public User getByEmail(String email) {
        LOG.info("mock getByEmail " + email);
        return null;
    }

    @Override
    public List<User> getAll() {
        LOG.info("mock getAll");
        return null;
    }
}
