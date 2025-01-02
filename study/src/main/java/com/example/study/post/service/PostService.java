package com.example.study.post.service;

import com.example.study.common.exception.NullTitleException;
import com.example.study.common.exception.LengthTitleException;
import com.example.study.post.controller.dto.PostListResponse;
import com.example.study.post.controller.dto.PostRequestDTO;
import com.example.study.post.domain.entity.Post;
import com.example.study.post.domain.repository.PostRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PostService {

    private final PostRepository postRepository;

    public PostService(final PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    public PostListResponse createPost(Long memberId, PostRequestDTO postRequestDTO) {
        validateTitle(postRequestDTO.getTitle());
        Post post = new Post(memberId, postRequestDTO.getTitle(), postRequestDTO.getContent(), postRequestDTO.getPassword());
        postRepository.save(post);
        return new PostListResponse(post);
    }

    public List<PostListResponse> findAllPost() {
        List<Post> boardList = postRepository.findAll();
        List<PostListResponse> responseDtoList = new ArrayList<>();
        for (Post post : boardList) {
            responseDtoList.add(
                    new PostListResponse(post)
            );
        }
        return responseDtoList;
    }

    private void validateTitle(final String title)  {
        if (title.isEmpty()) {
            throw new NullTitleException();
        }
        if (title.length() > 10) {
            throw new LengthTitleException();
        }
    }

}
