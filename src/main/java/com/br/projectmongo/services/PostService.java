package com.br.projectmongo.services;

import com.br.projectmongo.domain.Post;
import com.br.projectmongo.domain.User;
import com.br.projectmongo.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PostService {

    @Autowired
    private PostRepository repository;

    public Post findById(String id) {
        Optional<Post> post = repository.findById(id);
        return post
                .orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
    }

}