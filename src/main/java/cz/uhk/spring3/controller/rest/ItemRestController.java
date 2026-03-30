package cz.uhk.spring3.controller.rest;

import cz.uhk.spring3.model.Item;
import cz.uhk.spring3.service.ItemService;
import cz.uhk.spring3.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rest/items")
public class ItemRestController {

    private ItemService itemService;
    private UserService userService;

    @Autowired
    public ItemRestController(ItemService itemService, UserService userService) {
        this.itemService = itemService;
        this.userService = userService;
    }

    @GetMapping("/")
    public List<Item> list(Model model){
        return itemService.getAllItems();
    }

    @GetMapping("/{id}")
    public Item detail(@PathVariable int id){
        return itemService.getItem(id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id){
        Item u = itemService.getItem(id);
        if (u != null) {
            itemService.deleteItem(u);
        }
    }

    @PutMapping("/{id}")
    public void update(@ModelAttribute Item item){
        itemService.saveItem(item);
    }

    @PostMapping("/new")
    public void create(@ModelAttribute Item item){
        itemService.saveItem(item);
    }

}
