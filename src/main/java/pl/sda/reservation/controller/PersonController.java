package pl.sda.reservation.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import pl.sda.reservation.model.Person;

@Controller
public class PersonController {

    @GetMapping(path = "/personForm")
    public String getPersonForm(Model model){
        Person person = new Person();

        model.addAttribute("person", person);

        return "personForm";
    }

    @PostMapping(path = "/personForm")
    public String showPerson(Person person){
        System.out.println(person);
        return "redirect:/";
    }

}
