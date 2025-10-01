package com.example.umc1.domain.post.dto;

import lombok.*;

@Setter
@Getter
@AllArgsConstructor
public class PostRequestDto {
    private String title;
    private String content;
    private String author;
}
