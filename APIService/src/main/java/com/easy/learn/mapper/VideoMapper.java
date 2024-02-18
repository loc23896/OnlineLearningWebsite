package com.easy.learn.mapper;

import com.easy.learn.dto.VideoDTO;
import com.easy.learn.entity.Video;
import org.springframework.stereotype.Service;

@Service
public class VideoMapper extends AbstractMapper<Video, VideoDTO> {
    public VideoMapper(){
        super(Video.class, VideoDTO.class);
    }
}
