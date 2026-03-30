package cz.uhk.spring3.controller.rest;

import cz.uhk.spring3.model.User;
import cz.uhk.spring3.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rest/users")
public class UserRestController {

    private UserService userService;

    @Autowired
    public UserRestController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public List<User> list(Model model){
        return userService.getAllUsers();
    }

    @GetMapping("/{id}")
    public User detail(@PathVariable int id){
        return userService.getUser(id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id){
        User u = userService.getUser(id);
        if (u != null) {
            userService.deleteUser(u);
        }
    }

    @PostMapping("/new")
    public void create(@ModelAttribute User user){
        userService.saveUser(user);
    }

    @PutMapping("/{id}")
    public void update(@ModelAttribute User user){
        userService.saveUser(user);
    }

}
