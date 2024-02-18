//package com.easy.learn.controller;
//
//import com.easy.learn.callApi.VideoService;
//import com.easy.learn.dto.LessonEdit.LessonEditDTO;
//import com.easy.learn.dto.VideoDto;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.*;
//import org.springframework.web.multipart.MultipartFile;
//
//@Controller
//@RequestMapping("/video")
//public class TestController {
//
//    @Autowired
//    VideoService videoService;
//
//    @GetMapping("/form")
//    public String showVideoForm(Model model) {
//        model.addAttribute("videos", videoService.getAllVideo());
//        return "pages/admin/admin_trainer/page_test_video_img/page_form.html";
//    }
//
//    @PostMapping("/form")
//    public String saveLessonToCourse(@RequestParam("video") MultipartFile videoCourseEdit,
//                                     @ModelAttribute("videoDto") VideoDto video) {
//        try {
//            video.setName(videoCourseEdit.getOriginalFilename());
//            video.setVideo(videoCourseEdit.getBytes());
//            videoService.createVideo(video);
//
//
//        }catch (Exception e){
//            throw new RuntimeException();
//        }
//        return "redirect:/video/form";
//
//    }
//
//}
