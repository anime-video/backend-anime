package com.example.backend.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "anime")
public class Anime {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name",columnDefinition = "VARCHAR(100)")
    private String name;

    @Column(name = "description",columnDefinition = "TEXT")
    private String description;

    @Column(name = "image_url",columnDefinition = "TEXT")
    private String imageUrl;

    @Column(name = "status",columnDefinition = "BOOLEAN")
    private boolean status;

    @Column(name = "trailer",columnDefinition = "TEXT")
    private String trailer;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    @OneToMany(mappedBy = "anime", cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<Video> videos;
}
