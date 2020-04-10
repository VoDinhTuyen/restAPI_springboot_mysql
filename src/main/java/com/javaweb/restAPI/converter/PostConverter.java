package com.javaweb.restAPI.converter;

import com.javaweb.restAPI.dto.PostDTO;
import com.javaweb.restAPI.entity.PostEntity;
import org.springframework.stereotype.Component;

@Component
public class PostConverter {

    public PostDTO toDTO(PostEntity postEntity) {
        PostDTO postDTO = new PostDTO();
        postDTO.setId(postEntity.getId());
        postDTO.setTitle(postEntity.getTitle());
        postDTO.setContent(postEntity.getContent());
        return postDTO;
    }

    public PostEntity toEntity(PostDTO postDTO) {
        PostEntity postEntity = new PostEntity();
        postEntity.setTitle(postDTO.getTitle());
        postEntity.setContent(postDTO.getContent());
        return postEntity;
    }

    public PostEntity toEntity(PostDTO postDTO, PostEntity postEntity) {
        postEntity.setTitle(postDTO.getTitle());
        postEntity.setContent(postDTO.getContent());
        return postEntity;
    }

}
