package com.example.study.post.controller.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class PostRequestDTO {

    private String title;

    private String content;

    private String password;
}
