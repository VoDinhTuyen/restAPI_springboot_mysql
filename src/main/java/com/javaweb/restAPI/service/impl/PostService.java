package com.javaweb.restAPI.service.impl;

import com.javaweb.restAPI.converter.PostConverter;
import com.javaweb.restAPI.dto.PostDTO;
import com.javaweb.restAPI.entity.PostEntity;
import com.javaweb.restAPI.exception.NotFoundException;
import com.javaweb.restAPI.repository.PostRepository;
import com.javaweb.restAPI.service.IPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PostService implements IPostService {

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private PostConverter postConverter;

    @Override
    public List<PostDTO> findAll() {
        List<PostDTO> results = new ArrayList<>();
        List<PostEntity> entities = postRepository.findAll();
        for(PostEntity entity: entities) {
            PostDTO postDTO = postConverter.toDTO(entity);
            results.add(postDTO);
        }
        return results;
    }

    @Override
    public PostDTO findOne(Long postId) {
        PostDTO postDTO = postConverter.toDTO(postRepository.findOneById(postId));
        return postDTO;
    }

    @Override
    public PostDTO addPost(PostDTO postDTO) {
        PostEntity postEntity = postConverter.toEntity(postDTO);
        postRepository.save(postEntity);
        return postDTO;
    }

    @Override
    public PostDTO updatePost(Long postId, PostDTO postDTO) {
        PostEntity postEntity = postRepository.findOneById(postId);
        if(postEntity == null) {
            throw new NotFoundException("Post record is not available!");
        }
        postRepository.save(postConverter.toEntity(postDTO, postEntity));
        return postDTO;
    }

    @Override
    public void deletePost(Long postId) {
        postRepository.deleteById(postId);
    }


}
