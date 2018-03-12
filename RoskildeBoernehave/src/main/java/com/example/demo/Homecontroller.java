package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.FileNotFoundException;
import java.util.*;

    @Controller
    public class Homecontroller {

         public static ArrayList<kid> kids = new ArrayList<kid>();

        @GetMapping("/")
        public String index(Model model) throws FileNotFoundException {
            if (kids.size() < 1) {
                kids.add(new kid(1, "Hans", "Hansen", new Date(2010-10-19), "Niels", "1234567"));
                kids.add(new kid(1, "Lars", "Larsen", new Date(2011-10-19), "Mathias", "7654321"));
            }
            model.addAttribute("kids", kids);
            //exportMemberData();
            return "index";
        }

    @GetMapping("/Medlem")
    public String Medlem(Model model) {
        model.addAttribute("kids", new kid());
        return "Medlem";

    }

    @PostMapping("/Medlem")
    public String Medlem(@ModelAttribute kid kid, BindingResult bindingResult) {
        int ID = 0;
        for (kid k : kids) {
            if (k.getKidId() >= ID) {
                ID = k.getKidId() + 1;
            }
        }
        kid.setKidId(ID);
        kids.add(kid);
        return "redirect:/";
    }

    @GetMapping("/info")
    public String info(@RequestParam(value = "id", defaultValue = "10") int id, Model model) {
        model.addAttribute("kid", kids.get(id));
        return "info";
    }

    @GetMapping("/slet")
    public String slet(@RequestParam(value = "id", defaultValue = "1") int id, Model model) {
        int chosenStudentID = 0;
        for (int i = 0; i < kids.size(); i++) {
            if (kids.get(i).getKidId() == id) {
                chosenStudentID = i;
            }
        }
        model.addAttribute("student", kids.get(chosenStudentID));
        return "slet";
    }

    /*@PostMapping("/delete")
    public String delete(){

    }*/

    @GetMapping("/Rediger")
    public String rediger(@RequestParam(value = "id", defaultValue = "10") int id, Model model) {
        int chosenStudentID = 0;
        for (int i = 0; i < kids.size(); i++) {
            if (kids.get(i).getKidId() == id) {
                chosenStudentID = i;
            }
        }
        model.addAttribute("Student", kids.get(chosenStudentID));
        return "Rediger";
    }
}