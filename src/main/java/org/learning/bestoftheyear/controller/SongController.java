package org.learning.bestoftheyear.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/songs")
public class SongController {

  @GetMapping
  public String songList() {
    return "songs/songs-list";
  }
}
