package web.service;

import web.models.User;

import java.util.List;

public interface UserService {
     void save(User user);
    List<User> allUsers();
    void update(User user, Long id);
    void delete(User user);
    User getById(Long id);

}
