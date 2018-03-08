package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.*;


    @Controller
    public class Homecontroller {

        ArrayList<kid> kids = new ArrayList<kid>();

        @GetMapping("/")
        public String index(Model model) {
            if (kids.size() < 1) {
                kids.add(new kid(1, "Hans", "Hansen", new Date(2010-10-19), "Niels", "1234567"));
            }
            model.addAttribute("kids", kids);
            return "index";
        }

        @GetMapping("/Medlem")
        public String Medlem(Model model) {
            model.addAttribute("kids", new kid());
            return "Medlem";

        }

        /*@PostMapping("/Medlem")
        public String Medlem(@ModelAttribute kid kid, BindingResult bindingResult) {
            int ID = 0;
            for (kid k : kids) {
                if (k.getKidId() >= ID) {
                    ID = k.getKidId() + 1;
                }
            }
            kid.setKidId(ID);
            kids.add(kid);
            return "redirect:/index.html";
        }*/


    }
