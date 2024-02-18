//package com.easy.learn.controller;
//
//import com.easy.learn.callApi.VideoService;
//import com.easy.learn.dto.VideoDto;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.*;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestMapping;
//
//import java.util.Optional;
//
//@Controller
//@RequestMapping("/api/videos")
//public class VideoTestController {
//
//    @Autowired
//    private VideoService videoService;
//
//    @GetMapping("/{videoId}")
//    public ResponseEntity<byte[]> getVideo(@PathVariable Long videoId) {
//        Optional<VideoDto> optionalVideo = Optional.ofNullable(videoService.getVideoById(videoId));
//
//        if (optionalVideo.isPresent()) {
//            VideoDto video = optionalVideo.get();
//            HttpHeaders headers = new HttpHeaders();
//            headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
//            headers.setContentDisposition(ContentDisposition.builder("attachment").filename(video.getName()).build());
//            return new ResponseEntity<>(video.getVideo(), headers, HttpStatus.OK);
//        }
//
//        return ResponseEntity.notFound().build();
//    }
//}
//
