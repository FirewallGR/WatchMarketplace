package ru.meowmure.clockwebmarket.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.meowmure.clockwebmarket.models.Watch;
import ru.meowmure.clockwebmarket.repositories.WatchRepository;

@Controller
public class WatchController {
    private final WatchRepository watchRepository;

    public WatchController(WatchRepository watchRepository) {
        this.watchRepository = watchRepository;
    }

    @GetMapping("/watches")
    public String getAllWatches(Model model) {
        Iterable<Watch> watches = watchRepository.findAll();
        model.addAttribute("watches", watches);
        return "/watches";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("watch", new Watch());
        return "/create";
    }

    @PostMapping("/create")
    public String create(@ModelAttribute("watch") Watch watch) {
        watchRepository.save(watch);
        return "redirect:/watches";
    }

    @PostMapping("/watches/save")
    public String saveWatch(@ModelAttribute Watch watch) {
        watchRepository.save(watch);
        return "redirect:/watches";
    }

    //Тебе бы короче сделать методы edit и remove
    //Дальше надо думать что хотим вообще сделать
    //Сделай пока просто по id

}
