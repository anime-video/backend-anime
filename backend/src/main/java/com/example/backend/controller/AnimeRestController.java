package com.example.backend.controller;

import com.example.backend.model.Anime;
import com.example.backend.service.IAnimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/anime")
@CrossOrigin(origins="*")
public class AnimeRestController {
    @Autowired
    private IAnimeService animeService;
    @PostMapping
    public ResponseEntity<Anime> createAnime(@RequestBody Anime anime) {
        Anime createdAnime = animeService.createAnime(anime);
        return new ResponseEntity<>(createdAnime, HttpStatus.CREATED);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Anime> getAnimeById(@PathVariable long id) {
        Anime anime = animeService.getAnimeById(id);
        return new ResponseEntity<>(anime, HttpStatus.OK);
    }
    @GetMapping
    public ResponseEntity<List<Anime>> getAllAnime() {
        List<Anime> animes = animeService.getAllAnime();
        return new ResponseEntity<>(animes, HttpStatus.OK);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Anime> updateAnime(@PathVariable long id, @RequestBody Anime anime) {
        anime.setId(id);
        Anime updatedAnime = animeService.updateAnime(anime);
        return new ResponseEntity<>(updatedAnime, HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAnime(@PathVariable long id) {
        animeService.deleteAnimeById(id, null);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/search")
    public ResponseEntity<List<Anime>> searchAnime(@RequestParam("name") String name) {
        List<Anime> animes = animeService.searchAnimeByName(name);
        return new ResponseEntity<>(animes, HttpStatus.OK);
    }
}
