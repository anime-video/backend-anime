package com.example.backend.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "videos")
public class Video {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "episode_number")
    private int episodeNumber;

    @Column(name = "video_url", columnDefinition = "TEXT")
    private String videoUrl;

    @ManyToOne
    @JoinColumn(name = "anime_id")
    @JsonBackReference// khóa ngoại trong bảng videos liên kết với bảng anime
    private Anime anime;
}
