package kamilolszewski.USD.Markings.controllers;

import kamilolszewski.USD.Markings.model.Rate;
import kamilolszewski.USD.Markings.service.RateService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;
import java.util.List;
import java.util.Set;

@Controller
@RequestMapping("/")
@Slf4j
public class MainController {

    @Autowired
    private RateService rateService;

    @GetMapping
    public String showMainPage(Model model) {
        model.addAttribute("data", "");
        return "home";
    }
    @GetMapping("/USD")
    public String showMarkings(@RequestParam(value = "data", required = false) String data, Model model) {
        List<Rate> rates = rateService.rate(data);
        model.addAttribute("rateService", rateService);
        model.addAttribute("rates", rates);
        model.addAttribute("data", "");
        return "markings";
    }
}
