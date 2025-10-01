package com.example.umc1.domain.post.dto;

import com.example.umc1.domain.post.entity.Post;
import lombok.Getter;
import java.time.LocalDateTime;

@Getter
public class PostResponseDto {
    private String title;
    private String content;
    private String author;
    private LocalDateTime createdDate;
    private LocalDateTime updatedDate;

    public static PostResponseDto of(Post post) {
        PostResponseDto postResponseDto = new PostResponseDto();
        postResponseDto.title = post.getTitle();
        postResponseDto.content = post.getContent();
        postResponseDto.author = post.getAuthor();
        postResponseDto.createdDate = post.getCreatedAt();
        postResponseDto.updatedDate = post.getUpdatedAt();

        return postResponseDto;
    }
}
