package web.service;

import web.models.User;
import java.util.List;

public interface UserService {

    List<User> allUsers();

    void save(User user);

    void delete(User user);

    User getById(Long id);

    User getUserByName(String username);
}
