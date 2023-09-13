package org.learning.bestoftheyear.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/movies")
public class MovieController {

  @GetMapping
  public String movieList() {
    // nome del template resources/templates/movie-list.html
    return "movies/movie-list";
  }
}
