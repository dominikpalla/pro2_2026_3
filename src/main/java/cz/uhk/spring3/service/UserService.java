package cz.uhk.spring3.service;

import cz.uhk.spring3.model.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
    void saveUser(User user);
    User getUser(long id);
    void deleteUser(User user);
    List<User> getAllUsers();
}
