package com.jobsearch.app.controller;

import com.jobsearch.app.repository.PostRepository;
import com.jobsearch.app.model.Post;
import com.jobsearch.app.repository.SearchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class PostController {
    @Autowired
    PostRepository postRepo;
    @Autowired
    SearchRepository searchRepo;

    @ApiIgnore
    @RequestMapping(value = "/")
    public void redirect(HttpServletResponse response) throws IOException {
        response.sendRedirect("/swagger-ui.html");
    }

    @GetMapping("/posts")
    @CrossOrigin
    public List<Post> getAllPosts() {
        return postRepo.findAll();
    }

    @GetMapping("/posts/{text}")
    @CrossOrigin
    public List<Post> search(@PathVariable String text) {
        return searchRepo.findByText(text);
    }

    @PostMapping("/post")
    @CrossOrigin
    public Post addPost(@RequestBody Post post) {
        return postRepo.save(post);
    }
}

