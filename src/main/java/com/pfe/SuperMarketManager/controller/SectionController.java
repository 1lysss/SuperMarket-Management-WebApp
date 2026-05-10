package com.pfe.SuperMarketManager.controller;

import com.pfe.SuperMarketManager.Model.Section;
import com.pfe.SuperMarketManager.service.SectionService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class SectionController {
    final private SectionService sectionService;

    public SectionController( SectionService sectionService) {
        this.sectionService = sectionService;
    }

    @GetMapping("/sections/")
    public String showSections(Model model) {
        model.addAttribute("showSections", sectionService.getAllSections());
        return "pages/section/sections";
    }


    @GetMapping("/sections/add")
    public String showAddForm(Model model) {
        model.addAttribute("section", new Section());
        return "pages/section/section_form";
    }
    @PostMapping("/sections/add")
    public String saveSection(@ModelAttribute Section section) {
        sectionService.addSection(section);
        return "redirect:/sections/";
    }


    @GetMapping("/sections/edit/{id}")
    public String showEditForm(@PathVariable Integer id, Model model) {
        Section section = sectionService.getSectionById(id).orElseThrow(() -> new RuntimeException("Section not found"));
        model.addAttribute("section", section);
        return "pages/section/section_form";
    }
    @PostMapping("/sections/edit/{id}")
    public String updateSection(@PathVariable Integer id, @ModelAttribute Section section) {
        Section existingSection = sectionService.getSectionById(id).orElseThrow(()->new RuntimeException("Section not found"));
        existingSection.setName(section.getName());
        existingSection.setDescription(section.getDescription());
        existingSection.setProducts(section.getProducts());

        sectionService.updateSection(section);
        return "pages/section/sections";
    }



    @PostMapping("/sections/delete/{id}")
    public String deleteSection(@PathVariable Integer id) {
        sectionService.deleteSection(id);
        return "redirect:/sections/";
    }
}
