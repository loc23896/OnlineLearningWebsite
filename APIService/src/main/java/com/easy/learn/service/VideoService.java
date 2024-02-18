package com.easy.learn.service;

import com.easy.learn.dto.VideoDTO;

import java.util.List;

public interface VideoService {
    List<VideoDTO> findAll();
    VideoDTO findById(Long id);
    VideoDTO create(VideoDTO videoDTO);
    boolean update(VideoDTO videoDTO);
    boolean delete(Long id);

}
