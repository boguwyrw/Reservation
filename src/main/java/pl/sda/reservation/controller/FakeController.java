package pl.sda.reservation.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(path = "/fun/")
public class FakeController {

    @GetMapping(path = "/multi")
    public String getMultiplicationTable(Model model, @RequestParam(name = "size") Integer size){
        model.addAttribute("size", size);
        return "multi";
    }

    @GetMapping(path = "/alphabet/{repetition}")
    public String getAlphabet(Model model, @PathVariable(name = "repetition") Integer repetition){

        List<Character> characters = new ArrayList<>();

        for(char i = 'a'; i < 'z'; i++){
            characters.add(i);
        }
        model.addAttribute("alphabet", characters);
        model.addAttribute("repetition", repetition);
        return "alphabet";
    }

}
