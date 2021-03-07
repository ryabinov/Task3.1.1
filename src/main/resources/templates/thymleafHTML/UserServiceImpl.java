package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import web.model.User;
import web.repository.UserRepository;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Repository
public class UserServiceImpl implements UserService {

    @Autowired
    PasswordEncoder bCryptPasswordEncoder;

    private UserRepository userRepository;
@Autowired
    public UserServiceImpl (UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Autowired
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> allUsers() {
        return userRepository.findAll();
    }

    @Transactional
    public void addUser(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        userRepository.save(user);
    }

    @Transactional
    public void update(User user) {
        userRepository.saveAndFlush(user);
    }

    @Transactional
    public void delete(User user) {
        userRepository.delete(user);
    }

    @Override
    public void deleteUserById(Long id) {
        userRepository.deleteById(id);
    }

    public User getById(Long id) {
        return userRepository.findById(id).orElse(null);
    }
}

