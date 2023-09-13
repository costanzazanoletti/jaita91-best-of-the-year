package org.learning.bestoftheyear.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class IndexController {

  // metodo che risponde alle request GET alla root
  @GetMapping
  public String index(Model model) {
    // aggiungo al Model un attributo name
    model.addAttribute("name", "Costanza");
    // restituisco il nome del template resources/templates/home.html
    return "home";
  }
  
}
