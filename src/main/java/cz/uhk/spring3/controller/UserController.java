package cz.uhk.spring3.controller;

import cz.uhk.spring3.model.User;
import cz.uhk.spring3.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/users")
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public String list(Model model){
        model.addAttribute("users", userService.getAllUsers());
        return "users_list";
    }

    @GetMapping("/{id}")
    public String detail(@PathVariable int id, Model model){
        model.addAttribute("user", userService.getUser(id));
        return "users_detail";
    }

    @GetMapping("/{id}/delete")
    public String delete(@PathVariable int id){
        User u = userService.getUser(id);
        if (u != null) {
            userService.deleteUser(u);
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
        User u = userService.getUser(id);
        if (u != null) {
            model.addAttribute("user", u);
            return "users_edit";
        }
        return "redirect:/users/";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute User user){
        userService.saveUser(user);
        return "redirect:/users/";
    }

}
