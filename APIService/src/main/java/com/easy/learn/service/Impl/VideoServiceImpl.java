package com.easy.learn.service.Impl;

import com.easy.learn.dto.VideoDTO;
import com.easy.learn.entity.Video;
import com.easy.learn.mapper.VideoMapper;
import com.easy.learn.repository.VideoRepository;
import com.easy.learn.service.VideoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
public class VideoServiceImpl implements VideoService {

    @Autowired
    VideoRepository videoRepository;

    @Autowired
    VideoMapper videoMapper;

    @Override
    public List<VideoDTO> findAll() {
        List<Video> videos = videoRepository.findAll();
        return videos.stream()
                .map(videoMapper::convertEntityToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public VideoDTO findById(Long id) {
        Optional<Video> videoOptional = videoRepository.findById(id);
        return videoOptional.map(videoMapper::convertEntityToDTO).orElse(null);
    }

    @Override
    public VideoDTO create(VideoDTO videoDTO) {
        Video video = videoMapper.convertDTOToEntity(videoDTO);
        Video createdVideo = videoRepository.save(video);
        return videoMapper.convertEntityToDTO(createdVideo);
    }

    @Override
    public boolean update(VideoDTO videoDTO) {
        try {
            Video video = videoMapper.convertDTOToEntity(videoDTO);
            videoMapper.convertEntityToDTO(videoRepository.saveAndFlush(video));
            return true;
        } catch (Exception e) {
            log.error("Error when updating:", e);
            return false;
        }
    }
    @Override
    public boolean delete(Long id) {
        if (videoRepository.existsById(id)) {
            videoRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
