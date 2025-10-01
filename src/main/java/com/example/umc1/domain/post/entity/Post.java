package com.example.umc1.domain.post.entity;

import com.example.umc1.domain.post.dto.PostRequestDto;
import jakarta.persistence.*;
import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import java.time.LocalDateTime;

@EntityListeners(AuditingEntityListener.class)
@Getter
@Entity
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String content;
    private String author;
    @CreatedDate
    private LocalDateTime createdAt;
    @LastModifiedDate
    private LocalDateTime updatedAt;

    public static Post of(PostRequestDto postRequestDto) {
        Post post = new Post();
        post.title = postRequestDto.getTitle();
        post.content = postRequestDto.getContent();
        post.author = postRequestDto.getAuthor();

        return post;
    }

    public static Post update(Post post, PostRequestDto postRequestDto) {
        if(postRequestDto.getTitle() != null)
            post.title = postRequestDto.getTitle();
        if(postRequestDto.getContent() != null)
            post.content = postRequestDto.getContent();
        if(postRequestDto.getAuthor() != null)
            post.author = postRequestDto.getAuthor();

        return post;
    }
}

