package org.learning.bestoftheyear.controller;

import java.util.ArrayList;
import java.util.List;
import org.learning.bestoftheyear.model.Movie;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/movies")
public class MovieController {

  @GetMapping
  public String movieList(Model model) {
    // recupero la lista dei movies
    List<Movie> fakeMovieList = getMovies();
    // aggiungo la lista dei movies come attributo del Model

    for (Movie m : fakeMovieList) {
      // faccio qualcosa
      System.out.println(m.getTitle());
    }

    model.addAttribute("movies", fakeMovieList);
    // nome del template resources/templates/movie-list.html
    return "movies/movie-list";
  }

  // metodo private che costruisce e ritorna una lista di Movie
  private List<Movie> getMovies() {
    List<Movie> movies = new ArrayList<>();
    // aggiungo dei movies fake di test
    movies.add(new Movie(1, "Ritorno a Java", "Pinco Pallo"));
    movies.add(new Movie(2, "Java e il Tempio Maledetto", "Severus Python"));
    movies.add(new Movie(1, "Harry Potter e il calice di Java", "James Potter"));
    return movies;
  }
}
