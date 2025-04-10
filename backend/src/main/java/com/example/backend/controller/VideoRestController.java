package com.example.backend.controller;

import com.example.backend.model.Video;
import com.example.backend.service.IVideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/videos")
@CrossOrigin(origins="*")
public class VideoRestController {
    @Autowired
    private IVideoService videoService;

    @GetMapping
    public ResponseEntity<List<Video>> getAllVideos() {
        List<Video> videos = videoService.getAllVideos();
        return ResponseEntity.ok(videos);
    }

    @PostMapping
    public ResponseEntity<Video> createVideo(@RequestBody Video video) {
        Video createdVideo = videoService.createVideo(video);
        return new ResponseEntity<>(createdVideo, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Video> getVideoById(@PathVariable long id) {
        Video video = videoService.getVideoById(id);
        if (video == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok(video);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Video> updateVideo(@PathVariable long id, @RequestBody Video video) {
        video.setId(id);
        try {
            Video updatedVideo = videoService.updateVideo(video);
            return ResponseEntity.ok(updatedVideo);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteVideo(@PathVariable long id) {
        videoService.deleteVideoById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
