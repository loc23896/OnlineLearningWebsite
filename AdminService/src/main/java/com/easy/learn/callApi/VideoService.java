package com.easy.learn.callApi;

import com.easy.learn.consts.ApiPath;
import com.easy.learn.dto.VideoDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Service
public class VideoService {
    @Value("${api.host.url}")
    String apiHostUrl;

    @Autowired
    RestTemplate restTemplate;

    public List<VideoDto> getAllVideo() {
        String url = apiHostUrl + ApiPath.VIDEO_GET_ALL;

        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<String> entity = new HttpEntity<>(headers);

        ResponseEntity<VideoDto> responseEntity = restTemplate.exchange(
                url,
                HttpMethod.GET,
                entity,
                new ParameterizedTypeReference<VideoDto>() {});

        VideoDto lessonEditDTO = responseEntity.getBody();

        return  lessonEditDTO.getList();
    }
    public VideoDto getVideoById(Long id) {
        String url = apiHostUrl + ApiPath.VIDEO_GET_ONE + "?id=" + id;

        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));

        HttpEntity<String> entity = new HttpEntity<>(headers);

        ResponseEntity<VideoDto> responseEntity = restTemplate.exchange(
                url,
                HttpMethod.GET,
                entity,
                new ParameterizedTypeReference<VideoDto>() {});

        VideoDto lessonEditDTO = responseEntity.getBody();

        return  lessonEditDTO.getData();
    }
    public VideoDto createVideo(VideoDto dto) {
        String url = apiHostUrl + ApiPath.VIDEO_CREATE;

        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<VideoDto> entity = new HttpEntity<>(dto, headers);

        ResponseEntity<VideoDto> responseEntity = restTemplate.exchange(
                url,
                HttpMethod.POST,
                entity,
                VideoDto.class
        );

        if (responseEntity.getStatusCode() == HttpStatus.CREATED) {
            return responseEntity.getBody();
        } else {
            return null;
        }
    }

    public VideoDto updateVideo(VideoDto dto) {
        String url = apiHostUrl + ApiPath.VIDEO_UPDATE;

        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<VideoDto> entity = new HttpEntity<>(dto, headers);

        ResponseEntity<VideoDto> responseEntity = restTemplate.exchange(
                url,
                HttpMethod.PUT,
                entity,
                VideoDto.class
        );

        if (responseEntity.getStatusCode() == HttpStatus.OK) {
            return responseEntity.getBody();
        } else {
            // Handle the error case
            // You might want to throw an exception or return null, depending on your use case
            return null;
        }
    }

    public boolean deleteVideo(Long id) {
        String url = apiHostUrl + ApiPath.VIDEO_DELETE + "?id=" + id;

        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));

        HttpEntity<String> entity = new HttpEntity<>(headers);

        ResponseEntity<Void> responseEntity = restTemplate.exchange(
                url,
                HttpMethod.DELETE,
                entity,
                Void.class
        );

        return responseEntity.getStatusCode() == HttpStatus.OK;
    }
}