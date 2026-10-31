package com.vaishnavi.malgudi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.vaishnavi.malgudi.entity.Settings;
import com.vaishnavi.malgudi.service.SettingsService;

@Controller
public class SettingsController {

    @Autowired
    private SettingsService service;

    @GetMapping("/settings")
    public String settings(Model model) {

        model.addAttribute(
                "settings",
                service.getAll());

        return "settings";
    }

    @GetMapping("/add-settings")
    public String addSettings(Model model) {

        model.addAttribute(
                "setting",
                new Settings());

        return "add-settings";
    }

    @PostMapping("/save-settings")
    public String saveSettings(
            Settings settings) {

        service.save(settings);

        return "redirect:/settings";
    }

    @GetMapping("/edit-settings/{id}")
    public String editSettings(
            @PathVariable Long id,
            Model model) {

        model.addAttribute(
                "setting",
                service.getById(id));

        return "edit-settings";
    }

    @GetMapping("/delete-settings/{id}")
    public String deleteSettings(
            @PathVariable Long id) {

        service.delete(id);

        return "redirect:/settings";
    }
}