package com.mytests.spring.reactive.webfluxfreemarker;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.reactive.result.view.Rendering;

@Controller
@RequestMapping("/foo/persons")
public class PersonController {

     @Autowired
     PersonRepo personRepo;
     
     @ModelAttribute("str_attr")
     public String str_attr(){
         return "fooBarAttribute";
     }

    @GetMapping("/")
    public Rendering getAll(){
        return Rendering.view("all")
                        .modelAttribute("family",personRepo.getAllPersons())
                        .build();
    }

    @GetMapping("/{id}")
    public String getById(Model model, @PathVariable String id) {
        model.addAttribute("id_attr", id);
        model.addAttribute("personById", personRepo.getPersonById(Integer.valueOf(id)));
        return "single";
    }
    @GetMapping("/names/{name}")
    public String getByName(Model model, @PathVariable String name) {
        model.addAttribute("name_attr", name);
        model.addAttribute("personsByName", personRepo.getPersonsByName(name));
        return "byName";
    }
    @GetMapping("/ages/{age}")
    public String getByAge(Model model, @PathVariable String age) {
        model.addAttribute("age_attr", age);
        model.addAttribute("personsByAge", personRepo.getPersonsByAge(Integer.valueOf(age)));
        return "byAge";
    }
}
