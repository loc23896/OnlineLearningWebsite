package com.easy.learn.controller;


import com.easy.learn.consts.ApiPath;
import com.easy.learn.dto.VideoDTO;
import com.easy.learn.response.VideoResponseDTO;
import com.easy.learn.service.VideoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
public class VideoController {
    @Autowired
    VideoService videoService;
    @GetMapping(value = ApiPath.VIDEO_GET_ALL)
    public ResponseEntity<VideoResponseDTO> getAllVideos() {
        VideoResponseDTO response = new VideoResponseDTO();
        try{
                     List<VideoDTO> list = videoService.findAll();
                        response.setList(list);
                        response.setMessage("Success get all users");
                        response.setErrorCode(200);
                        return new ResponseEntity<>(response, HttpStatus.OK);
                    } catch (Exception e) {
                        response.setMessage("Error when get all users:" + e);
                        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
                    }
        }

    @GetMapping(value = ApiPath.VIDEO_GET_ONE)
    public ResponseEntity<VideoResponseDTO> getVideoById(@RequestParam Long id) {
        VideoResponseDTO response = new VideoResponseDTO();
        try {
            VideoDTO video = videoService.findById(id);
            response.setData(video);
            response.setMessage("Success get video by ID");
            response.setErrorCode(200);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            response.setMessage("Error when get video by ID:" + e);
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping(value = ApiPath.VIDEO_CREATE)
    public ResponseEntity<VideoResponseDTO> addVideo(@RequestBody VideoDTO videoDTO) {
        VideoResponseDTO response = new VideoResponseDTO();
        try {
            VideoDTO createdVideo = videoService.create(videoDTO);
            response.setData(createdVideo);
            response.setMessage("Success create video");
            response.setErrorCode(200);
            return new ResponseEntity<>(response, HttpStatus.CREATED);
        } catch (Exception e) {
            response.setMessage("Error when create video:" + e);
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping(value = ApiPath.VIDEO_UPDATE)
    public ResponseEntity<VideoResponseDTO> updateVideo( @RequestBody VideoDTO videoDTO) {

        VideoResponseDTO response = new VideoResponseDTO();
        try {
            boolean updated = videoService.update(videoDTO);
            response.setMessage("Success update video");
            response.setErrorCode(200);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            response.setMessage("Error when update video:" + e);
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping(value = ApiPath.VIDEO_DELETE)
    public ResponseEntity<VideoResponseDTO> deleteVideo(@RequestParam Long id) {
        VideoResponseDTO response = new VideoResponseDTO();
        try {
            boolean deleted = videoService.delete(id);
            if (deleted) {
                response.setMessage("Success delete video");
                response.setErrorCode(200);
                return new ResponseEntity<>(response, HttpStatus.OK);
            } else {
                response.setMessage("Video not found");
                response.setErrorCode(404);
                return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            response.setMessage("Error when delete video:" + e);
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
