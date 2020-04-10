package com.javaweb.restAPI.repository;

import com.javaweb.restAPI.entity.PostEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends JpaRepository<PostEntity, Long> {

    PostEntity findOneById(Long id);

}
