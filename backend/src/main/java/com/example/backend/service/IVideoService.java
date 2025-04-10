package com.example.backend.service;

import com.example.backend.model.Video;

import java.util.List;

public interface IVideoService {
    Video getVideoById(long id);
    List<Video> getAllVideos();
    Video createVideo(Video video);
    Video updateVideo(Video video);
    void deleteVideoById(long id);
}
