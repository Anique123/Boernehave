package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.io.*;
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
            saveData();
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

        public static void saveData() throws FileNotFoundException {
                PrintWriter data = new PrintWriter(new FileOutputStream("/Users/au97/Documents/projekt/src/main/java/com/example/demo/kids"));
                for (kid k : kids){
                    data.println();
                }
                    data.close();
            }



    }
