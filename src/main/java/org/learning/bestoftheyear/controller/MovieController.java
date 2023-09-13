package org.learning.bestoftheyear.controller;

import java.util.ArrayList;
import java.util.List;
import org.learning.bestoftheyear.model.Movie;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.server.ResponseStatusException;

@Controller
@RequestMapping("/movies")
public class MovieController {

  @GetMapping // metodo che risponde a /movies
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

  // metodo che risponde a /movies/id_del_movie
  @GetMapping("/{id}") // {id} vuol dire una parte variabile del path
  public String movieDetail(@PathVariable("id") int movieId, Model model) {
    // nel metodo posso usare il valore di movieId che è stato letto dal path della request
    // ricerco nella lista di movies quello con l'id passato (movieId)
    List<Movie> movieList = getMovies();
    Movie movieToFind = null;
    for (Movie m : movieList) {
      // se l'id del Movie m è uguale a quello che cerco allora ho trovato il movie
      if (m.getId() == movieId) {
        movieToFind = m;
      }
    }
    // prima di passare il movieToFind al model, testo che non sia null
    if (movieToFind == null) {
      // non esiste un movie con l'id che mi hanno passato dalla request
      // quindi tiro un'eccezione
      throw new ResponseStatusException(HttpStatus.NOT_FOUND,
          "Movie with id " + movieId + " not found");
    }

    // passo il Movie al template come attributo
    model.addAttribute("movie", movieToFind);
    return "movies/movie-detail";
  }

  // metodo private che costruisce e ritorna una lista di Movie
  private List<Movie> getMovies() {
    List<Movie> movies = new ArrayList<>();
    // aggiungo dei movies fake di test
    movies.add(new Movie(1, "Ritorno a Java", "Pinco Pallo"));
    movies.add(new Movie(2, "Java e il Tempio Maledetto", "Severus Python"));
    movies.add(new Movie(3, "Harry Potter e il calice di Java", "James Potter"));
    return movies;
  }
}
