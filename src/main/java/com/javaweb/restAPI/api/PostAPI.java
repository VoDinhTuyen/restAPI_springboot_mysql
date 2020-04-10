package com.javaweb.restAPI.api;

import com.javaweb.restAPI.dto.PostDTO;
import com.javaweb.restAPI.service.IPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/post")
public class PostAPI {

    @Autowired
    private IPostService postService;

    @RequestMapping(method = RequestMethod.GET)
    public List<PostDTO> listPost() {
        return postService.findAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public PostDTO getPost(@PathVariable("id") Long id) {
        return postService.findOne(id);
    }

    @RequestMapping(method = RequestMethod.POST)
    public PostDTO addPost(@RequestBody PostDTO postDTO) {
        return postService.addPost(postDTO);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public PostDTO updatePost(@PathVariable("id") Long id, @RequestBody PostDTO postDTO) {
        return postService.updatePost(id, postDTO);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deletePost(@PathVariable("id") Long id) {
        postService.deletePost(id);
    }

}
