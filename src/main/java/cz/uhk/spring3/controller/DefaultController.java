package cz.uhk.spring3.controller;

import cz.uhk.spring3.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DefaultController {

    private WeatherService weatherService;

    @Autowired
    public DefaultController(WeatherService weatherService) {
        this.weatherService = weatherService;
    }

    @GetMapping("/")
    public String index(Model model) {
        String temp = weatherService.getTemp("Hradec Kralove");
        model.addAttribute("temp", temp);
        return "index";
    }

    @GetMapping("/403")
    public String forbidden(){
        return "403";
    }

    @GetMapping("/admin")
    public String admin(){
        return "admin";
    }

}
