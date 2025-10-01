package com.example.umc1.domain.post.service;

import com.example.umc1.domain.post.dto.PostRequestDto;
import com.example.umc1.domain.post.dto.PostResponseDto;
import com.example.umc1.domain.post.entity.Post;
import com.example.umc1.domain.post.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class PostService {
    private final PostRepository postRepository;

    public void savePost(PostRequestDto postRequestDto) {
        Post post = Post.of(postRequestDto);
        postRepository.save(post);
    }

    public List<PostResponseDto> getPostList() {
        List<Post> postList = postRepository.findAll();
        List<PostResponseDto> postResponseDtoList = postList.stream().map(PostResponseDto::of).toList();

        return postResponseDtoList;
    }

    public void updatePost(Long postId, PostRequestDto postRequestDto) {
        Optional<Post> optionalPost = postRepository.findById(postId);
        if (optionalPost.isEmpty()) {
            throw new NullPointerException("정보가 없습니다.");
        }
        Post post = optionalPost.get();
        post = Post.update(post, postRequestDto);

        postRepository.save(post);
    }

    public void deletePost(Long postId) {
        postRepository.deleteById(postId);
    }
}
