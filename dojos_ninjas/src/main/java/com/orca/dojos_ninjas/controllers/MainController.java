package com.orca.dojos_ninjas.controllers;

import com.orca.dojos_ninjas.models.Dojo;
import com.orca.dojos_ninjas.models.Ninja;
import com.orca.dojos_ninjas.services.DojoService;
import com.orca.dojos_ninjas.services.NinjaService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.List;

@Controller
public class MainController {
    private final DojoService dojoService;

    private final NinjaService ninjaService;

    public MainController(DojoService dojoService, NinjaService ninjaService){
        this.dojoService = dojoService;
        this.ninjaService = ninjaService;
    }

    @GetMapping("/")
    public String redirect(){
        return "redirect:/dojos";
    }

    @GetMapping("/dojos")
    public String getDojos(Model model, @ModelAttribute("dojo") Dojo dojo){
        model.addAttribute("dojos", dojoService.allDojo());
        return "index.jsp";
    }


    @PostMapping("/dojo/new")
    public String createDojo(Model model, @Valid @ModelAttribute("dojo") Dojo dojo, BindingResult result){
        if(result.hasErrors()){
            model.addAttribute("dojos", dojoService.allDojo());
            return "index.jsp";
        }
        else{
            dojoService.save(dojo);
            return "redirect:/";
        }
    }

    @GetMapping("/ninja/new")
    public String newninja(@ModelAttribute("ninja") Ninja ninja, Model model) {
        model.addAttribute("ninja", ninja);
        model.addAttribute("dojos", dojoService.allDojo());
        return "newninja.jsp";

    }

    @PostMapping("/ninja/new")
    public String createninja(Model model, @Valid @ModelAttribute("ninja") Ninja ninja, BindingResult result){
        if (result.hasErrors()){
            return "newninja.jsp";
        }
        else{
            ninjaService.save(ninja);
            return "redirect:/";
        }
    }

    @GetMapping("/dojos/{id}")
    public String showdojo(Model model, @PathVariable("id")Long id){
        Dojo dojo = dojoService.findDojo(id);
        model.addAttribute(dojo);
        return "dojo.jsp";
    }
}
