package com.example.backend.service;

import com.example.backend.model.Video;
import com.example.backend.repository.VideoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VideoServiceImplement implements IVideoService{
    @Autowired
    private VideoRepository videoRepository;

    public Video getVideoById(long id){
       Optional<Video> video = videoRepository.findById(id);
       return video.orElse(null);
    }

    public List<Video> getAllVideos(){
        return videoRepository.findAll();
    }
    public Video createVideo(Video video){
        return videoRepository.save(video);
    }
    public Video updateVideo(Video video){
        if (videoRepository.existsById(video.getId())) {
            return videoRepository.save(video);
        } else {
            throw new RuntimeException("Video not found with id: " + video.getId());
        }
    }

    public void deleteVideoById(long id){
        videoRepository.deleteById(id);
    }


}
