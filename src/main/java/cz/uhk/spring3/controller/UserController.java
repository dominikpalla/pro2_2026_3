package cz.uhk.spring3.controller;

import cz.uhk.spring3.model.User;
import org.jspecify.annotations.Nullable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@Controller
@RequestMapping("/users")
public class UserController {

    private ArrayList<User> users = new ArrayList<User>();

    public UserController() {
        User u = new User();
        u.setName("Karel");
        u.setId(1);
        users.add(u);
    }

    @GetMapping("/")
    public String list(Model model){
        model.addAttribute("users", users);
        return "users_list";
    }

    @GetMapping("/{id}")
    public String detail(@PathVariable int id, Model model){
        model.addAttribute("user", findUserById(id));
        return "users_detail";
    }

    private User findUserById(int id) {
        for (User user : users) {
            if (user.getId() == id) {
                return user;
            }
        }
        return null;
    }

    @GetMapping("/{id}/delete")
    public String delete(@PathVariable int id){
        User u = findUserById(id);
        if (u != null) {
            users.remove(u);
        }
        return "redirect:/users/";
    }

    @GetMapping("/create")
    public String create(Model model){
        model.addAttribute("user", new User());
        return "users_edit";
    }

    @GetMapping("/{id}/edit")
    public String edit(@PathVariable int id, Model model){
        User u = findUserById(id);
        if (u != null) {
            model.addAttribute("user", u);
            return "users_edit";
        }
        return "redirect:/users/";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute User user){
        if(user.getId() != 0){
            User orginal = findUserById(user.getId());
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
        return "redirect:/users/";
    }

}
