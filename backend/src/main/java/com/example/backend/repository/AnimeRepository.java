package com.example.backend.repository;

import com.example.backend.model.Anime;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AnimeRepository extends JpaRepository<Anime, Long> {
    List<Anime> findByNameContainingIgnoreCase(String name);
}
