package com.theismann.dojolanguages.controllers;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.theismann.dojolanguages.models.Language;
import com.theismann.dojolanguages.services.LanguageService;

@Controller
	public class LanguageController {
	private final LanguageService languageService;
	
	public LanguageController(LanguageService service) {
		this.languageService = service;
	}
	
	@RequestMapping("/languages")
	public String home(Model viewModel, @ModelAttribute("language") Language language) {
		viewModel.addAttribute("allLanguages", this.languageService.allLanguages());
		return "index.jsp";
	}
	
	@PostMapping("/languages")
    public String create(@Valid @ModelAttribute("language") Language language, BindingResult result, Model viewModel) {
        if (result.hasErrors()) {
        	viewModel.addAttribute("allLanguages", this.languageService.allLanguages());
            return "index.jsp";
        } else {
        	this.languageService.createLanguage(language);
        	
            return "redirect:/languages";
        }
	}
        
    @RequestMapping("/languages/{id}")
        public String showOne(@PathVariable("id")Long id, Model viewModel) {
    	Language showLanguage = this.languageService.findLanguage(id);
    		viewModel.addAttribute("showLanguage", showLanguage);
    		return "show.jsp";
    }
    
    @RequestMapping("/languages/{id}/edit")
    public String edit(@PathVariable("id") Long id, Model model) {
    	Language language = languageService.findLanguage(id);
        model.addAttribute("language", language);
        return "edit.jsp";
    }
    
    @RequestMapping(value="/languages/{id}/update", method=RequestMethod.POST)
    public String update(@Valid @ModelAttribute("language") Language language, BindingResult result) {
        if (result.hasErrors()) {
            return "edit.jsp";
        } else {
        	this.languageService.updateLanguage(language);
            return "redirect:/languages";
        }
    }
    
    @RequestMapping(value="/languages/{id}/delete")
    public String destroy(@PathVariable("id") Long id) {
    	languageService.deleteLanguage(id);
        return "redirect:/languages";
    }
}
