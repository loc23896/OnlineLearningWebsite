package com.easy.learn.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VideoDto extends ResponseDTO<VideoDto> {
    private Long id;
    private String name;
    private byte[] video;

}

