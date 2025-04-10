package com.example.backend.service;

import com.example.backend.model.Anime;

import java.util.List;

public interface IAnimeService {
    Anime createAnime(Anime anime);
    Anime getAnimeById(long id);
    List<Anime> getAllAnime();
    Anime updateAnime(Anime anime);
    void deleteAnimeById(long id, Anime anime);
    List<Anime> searchAnimeByName(String name);
}
