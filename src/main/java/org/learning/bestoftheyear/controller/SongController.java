package org.learning.bestoftheyear.controller;

import java.util.ArrayList;
import java.util.List;
import org.learning.bestoftheyear.model.Song;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.server.ResponseStatusException;

@Controller
@RequestMapping("/songs")
public class SongController {

  @GetMapping
  public String songList(Model model) {
    // recupero la lista delle Song
    List<Song> fakeSongList = getSongs();
    // aggiungo un attributo songs al model contenente la lista
    model.addAttribute("songs", fakeSongList);
    // ritorno il template songs-list.html
    return "songs/songs-list";
  }

  @GetMapping("/{id}")
  public String songDetail(@PathVariable("id") int songId, Model model) {
    // recuperlo la lista di Song
    List<Song> songs = getSongs();
    // cerco la Song con l'id passato nel path della request
    Song songToFind = null;
    for (Song s : songs) {
      if (s.getId() == songId) {
        songToFind = s;
      }
    }
    // se la Song con quell'id non esiste sollevo un'eccezione
    if (songToFind == null) {
      throw new ResponseStatusException(HttpStatus.NOT_FOUND,
          "Song with id " + songId + " not found");
    }
    // aggiungo al model l'attributo con la Song trovata
    model.addAttribute("song", songToFind);
    return "songs/song-detail";
  }


  // metodo private per generare e restituire una lista di Song
  private List<Song> getSongs() {
    List<Song> songs = new ArrayList<>();
    // popolo la lista
    songs.add(new Song(1, "I hate Javascript", "Me myself and I"));
    songs.add(new Song(2, "CSS forever", "Whoever"));
    songs.add(new Song(3, "Midnight in Java", "Unknown"));
    // ritorno la lista
    return songs;
  }
}
