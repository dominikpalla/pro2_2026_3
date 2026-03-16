package cz.uhk.spring3.controller;

import cz.uhk.spring3.model.Item;
import cz.uhk.spring3.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/items")
public class ItemController {

    private ItemService itemService;

    @Autowired
    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    @GetMapping("/")
    public String list(Model model){
        model.addAttribute("items", itemService.getAllItems());
        return "items_list";
    }

    @GetMapping("/{id}")
    public String detail(@PathVariable int id, Model model){
        model.addAttribute("item", itemService.getItem(id));
        return "items_detail";
    }

    @GetMapping("/{id}/delete")
    public String delete(@PathVariable int id){
        Item u = itemService.getItem(id);
        if (u != null) {
            itemService.deleteItem(u);
        }
        return "redirect:/items/";
    }

    @GetMapping("/create")
    public String create(Model model){
        model.addAttribute("item", new Item());
        return "items_edit";
    }

    @GetMapping("/{id}/edit")
    public String edit(@PathVariable int id, Model model){
        Item u = itemService.getItem(id);
        if (u != null) {
            model.addAttribute("item", u);
            return "items_edit";
        }
        return "redirect:/items/";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute Item item){
        itemService.saveItem(item);
        return "redirect:/items/";
    }

}
