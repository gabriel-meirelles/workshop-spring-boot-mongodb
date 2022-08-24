package com.br.projectmongo.resources;

import com.br.projectmongo.domain.Post;
import com.br.projectmongo.resources.util.URL;
import com.br.projectmongo.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/posts")
public class PostResources {

    @Autowired
    private PostService service;

    @GetMapping(value = "/{id}")
    public ResponseEntity<Post> findById(@PathVariable String id) {
        Post post = service.findById(id);
        return ResponseEntity.ok().body(post);
    }

    @GetMapping(value = "/titleSearch")
    public ResponseEntity<List<Post>> findByTitle(@RequestParam(value = "text", defaultValue = "")
                                                  String text) {
        text = URL.decodeParam(text);
        List<Post> post = service.findByTitle(text);
        return ResponseEntity.ok().body(post);
    }

}