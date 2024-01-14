package notebook.controller;

import notebook.model.User;
import notebook.model.repository.GBRepository;

import java.io.File;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class UserController {
    private final GBRepository repository;

    public UserController(GBRepository repository) {
        this.repository = repository;
    }

    public void saveUser(User user) {
        repository.create(user);
    }

    public User readUser(Long userId) throws Exception {
        List<User> users = repository.findAll();
        for (User user : users) {
            if (Objects.equals(user.getId(), userId)) {
                return user;
            }
        }

        throw new RuntimeException("User not found");
    }

    public void updateUser(String userId, User update) {
        repository.update(Long.parseLong(userId), update);

    }

    public List<User> readAll() {

        return repository.findAll();
    }

    public void delete(Long id) {
        repository.delete(Long.parseLong(String.valueOf(id)));
    }

    public User create() {
        return repository.create(repository.createUser());
    }

}
