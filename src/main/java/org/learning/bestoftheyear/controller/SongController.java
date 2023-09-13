package org.learning.bestoftheyear.controller;

import java.util.ArrayList;
import java.util.List;
import org.learning.bestoftheyear.model.Song;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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
