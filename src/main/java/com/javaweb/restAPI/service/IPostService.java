package com.javaweb.restAPI.service;

import com.javaweb.restAPI.dto.PostDTO;

import java.util.List;

public interface IPostService {

    List<PostDTO> findAll();
    PostDTO findOne(Long postId);
    PostDTO addPost(PostDTO postDTO);
    PostDTO updatePost(Long postId, PostDTO postDTO);
    void deletePost(Long postId);
}
