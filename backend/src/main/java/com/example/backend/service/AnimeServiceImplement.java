package com.example.backend.service;

import com.example.backend.model.Anime;
import com.example.backend.repository.AnimeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AnimeServiceImplement implements IAnimeService {
    @Autowired
    private AnimeRepository animeRepository;

    @Override
    public Anime createAnime(Anime anime) {
        return animeRepository.save(anime);
    }

    @Override
    public Anime getAnimeById(long id) {
        Optional<Anime> optionalAnime = animeRepository.findById(id);
        return optionalAnime.orElseThrow(() -> new RuntimeException("Anime not found with id " + id));
    }

    @Override
    public List<Anime> getAllAnime() {
        return animeRepository.findAll();
    }


    @Override
    public Anime updateAnime(Anime anime) {
        // Kiểm tra xem anime có tồn tại không dựa vào id được gửi từ client
        Anime existingAnime = getAnimeById(anime.getId());
        existingAnime.setName(anime.getName());
        existingAnime.setDescription(anime.getDescription());
        existingAnime.setImageUrl(anime.getImageUrl());
        existingAnime.setStatus(anime.isStatus());
        // Nếu có liên kết với Category, cần cập nhật thêm
        existingAnime.setCategory(anime.getCategory());
        return animeRepository.save(existingAnime);
    }
    @Override
    public void deleteAnimeById(long id, Anime anime) {
        // Ở đây, chỉ cần lấy anime theo id và xóa
        Anime existingAnime = getAnimeById(id);
        animeRepository.delete(existingAnime);
    }

    @Override
    public List<Anime> searchAnimeByName(String name){
        return animeRepository.findByNameContainingIgnoreCase(name);
    }
}
