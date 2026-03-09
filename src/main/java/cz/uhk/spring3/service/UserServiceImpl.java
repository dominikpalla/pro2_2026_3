package cz.uhk.spring3.service;

import cz.uhk.spring3.model.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private ArrayList<User> users = new ArrayList<User>();

    @Override
    public void saveUser(User user) {
        if(user.getId() != 0){
            User orginal = getUser(user.getId());
            if(orginal != null){
                users.remove(orginal);
            }
        } else {
            user.setId(1);
            if(!users.isEmpty()){
                user.setId(users.get(users.size()-1).getId() + 1);
            }
        }
        users.add(user);
    }

    @Override
    public User getUser(long id) {
        for (User user : users) {
            if (user.getId() == id) {
                return user;
            }
        }
        return null;
    }

    @Override
    public void deleteUser(User user) {
        users.remove(user);
    }

    @Override
    public List<User> getAllUsers() {
        return users;
    }
}
