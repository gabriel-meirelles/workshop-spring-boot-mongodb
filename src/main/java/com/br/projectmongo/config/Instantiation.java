package com.br.projectmongo.config;

import com.br.projectmongo.domain.Post;
import com.br.projectmongo.domain.User;
import com.br.projectmongo.dto.AuthorDTO;
import com.br.projectmongo.repository.PostRepository;
import com.br.projectmongo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

@Configuration
public class Instantiation implements CommandLineRunner {

    @Autowired
    private UserRepository repository;
    @Autowired
    private PostRepository postRepository;

    @Override
    public void run(String... args) throws Exception {

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        sdf.setTimeZone(TimeZone.getTimeZone("GMT"));

        repository.deleteAll();
        postRepository.deleteAll();

        User maria = new User(null, "Maria Brown", "maria@gmail.com");
        User alex = new User(null, "Alex Green", "alex@gmail.com");
        User bob = new User(null, "Bob Grey", "bob@gmail.com");

        repository.saveAll(Arrays.asList(maria, alex, bob));

        Post post1 = new Post(null,sdf.parse("10/08/2022"), "Partiu Viagem", "Vou viajar para são Paulo", new AuthorDTO(maria));
        Post post2 = new Post(null,sdf.parse("11/08/2022"), "Bom dia", "Acordei Felix hoje", new AuthorDTO(maria));


        postRepository.saveAll(Arrays.asList(post1,post2));
    }
}
