package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.*;

    @Controller
    public class Homecontroller {

        public static ArrayList<kid> kids = new ArrayList<kid>();

        @GetMapping("/")
        public String index(Model model) throws FileNotFoundException {
            if (kids.size() < 1) {
                kids.add(new kid(1, "Hans", "Hansen",new Date(2010), "Niels", "1234567"));
                kids.add(new kid(2, "Lars", "Larsen", new Date(2011), "Mathias", "7654321"));
                kids.add(new kid(3, "Mikkel", "Mikkelsen", new Date(2012), "Christian", "3456321"));
            }
            model.addAttribute("kids", kids);
            exportMemberData();
            return "index";
        }

        @GetMapping("/Medlem")
        public String registrering(Model model) {
            model.addAttribute("kids", new kid());
            return "Medlem";

        }

        @PostMapping("/Medlem")
        public String registrering(@ModelAttribute kid kid, BindingResult bindingResult) throws  FileNotFoundException {
            int ID = 0;
            for (kid k : kids) {
                if (k.getKidId() >= ID) {
                    ID = k.getKidId() + 1;
                }
            }
            kid.setKidId(ID);
            kids.add(kid);
            exportMemberData();
            return "redirect:/";
        }

        @GetMapping("/slet")
        public String slet(@RequestParam(value = "id", defaultValue = "1") int id, Model model) {
            int chosenStudentID = id;
            for (int i = 0; i < kids.size(); i++) {
                if (kids.get(i).getKidId() == id) {
                    chosenStudentID = i;
                }
            }
            model.addAttribute("kids", kids.get(chosenStudentID));
            return "slet";
        }


    /*@PostMapping("/delete")
    public String delete(){

    }*/

        @GetMapping("/Rediger")
        public String Rediger(@RequestParam(value = "id", defaultValue = "1") int id, Model model) {
            int chosenStudentID = 0;
            for (int i = 0; i < kids.size(); i++) {
                if (kids.get(i).getKidId() == id) {
                    chosenStudentID = i;
                }
            }
            model.addAttribute("kids", kids.get(chosenStudentID));
            
            return "Rediger";
        }

        /*@PostMapping("/Rediger")
        public String Rediger(@ModelAttribute kid kid){

        }*/


        public static void exportMemberData() throws FileNotFoundException {
            PrintStream memberData = new PrintStream(new File("/Users/au97/Documents/RoskildeBoernehave/src/main/java/com/example/demo/kids"));
            for (int i = 0; i < kids.size(); i++) {
                memberData.print(kids.get(i) + "\n");
            }
        }

    }