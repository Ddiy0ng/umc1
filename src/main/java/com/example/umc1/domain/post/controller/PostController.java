package com.example.umc1.domain.post.controller;

import com.example.umc1.domain.post.dto.PostRequestDto;
import com.example.umc1.domain.post.dto.PostResponseDto;
import com.example.umc1.domain.post.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/posts")
@RequiredArgsConstructor
@RestController
public class PostController {
    private final PostService postService;

    @PostMapping()
    public ResponseEntity<String> savePost(@RequestBody PostRequestDto postRequestDto) {
        postService.savePost(postRequestDto);
        return ResponseEntity.ok("게시글을 생성했습니다.");
    }

    @GetMapping()
    public ResponseEntity<List<PostResponseDto>> getPostList() {
        List<PostResponseDto> postList = postService.getPostList();

        return ResponseEntity.ok(postList);
    }

    @PatchMapping("/{postId}")
    public ResponseEntity<String> updatePost(@PathVariable Long postId, @RequestBody PostRequestDto postRequestDto) {
        postService.updatePost(postId, postRequestDto);
        return ResponseEntity.ok("게시글을 수정했습니다.");
    }

    @DeleteMapping("/{postId}")
    public ResponseEntity<String> deletePost(@PathVariable Long postId) {
        postService.deletePost(postId);

        return ResponseEntity.ok("게시글을 삭제했습니다.");
    }
}
