package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import web.models.User;
import web.repository.UserRepository;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Repository
public class UserServiceImpl implements UserDetailsService, UserService {

    @Autowired
    PasswordEncoder bCryptPasswordEncoder;

    private UserRepository userRepository;

    @Autowired
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> allUsers() {
        return userRepository.findAll();
    }

    @Transactional
    public void save(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        userRepository.save(user);
    }

    @Transactional
    public void update(User user, Long id) {
        userRepository.saveAndFlush(user);
    }

    @Transactional
    public void delete(User user) {
        userRepository.delete(user);
    }

    public User getById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public UserDetails loadUserByUsername(String username) {
        return userRepository.findByname(username).orElse(null);
    }
}
