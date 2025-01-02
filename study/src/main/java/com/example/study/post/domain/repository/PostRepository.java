package com.example.study.post.domain.repository;

import com.example.study.post.controller.dto.PostListResponse;
import com.example.study.post.domain.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostRepository extends JpaRepository<Post,Long> {
    List<PostListResponse> findAllByOrderByModifiedAtDesc();

    List<PostListResponse> findAllByCommentsAndId(Long memberId);

    Post findByIdAAndMemberId(Long id, Long memberId);

    void deleteByIdAndMemberId(Long memberId,Long id);

    Post findAllByMemberId(Long memberId);
}
