package com.myprojeto.workshopMongoDB.config;

import com.myprojeto.workshopMongoDB.domain.Post;
import com.myprojeto.workshopMongoDB.domain.User;
import com.myprojeto.workshopMongoDB.dto.AuthorDTO;
import com.myprojeto.workshopMongoDB.dto.CommentDTO;
import com.myprojeto.workshopMongoDB.repositories.PostRepository;
import com.myprojeto.workshopMongoDB.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.TimeZone;

@Configuration
public class Instantiation implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PostRepository postRepository;

    @Override
    public void run(String... args) throws Exception {

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
        //
        userRepository.deleteAll();
        postRepository.deleteAll();
        //
        User maria  = new User(null, "Maria Brown", "maria@gmail.com");
        User alex  = new User(null, "Alex Grey", "alex@gmail.com");
        User bob  = new User(null, "Bob Green", "bob@gmail.com");
        //
        userRepository.saveAll(Arrays.asList(maria, alex, bob));
        //
        Post post1 = new Post(null, sdf.parse("21/03/2018"), "Partiu viagem", "Vou viajar para São Paulo, abraços!", new AuthorDTO(maria));
        Post post2 = new Post(null, sdf.parse("23/03/2018"), "Bom dia", "Acordei feliz hoje!", new AuthorDTO(maria));
        //
        CommentDTO comment1 = new CommentDTO("Boa viagem, mano!", sdf.parse("21/03/2018"), new AuthorDTO(alex));
        CommentDTO comment2 = new CommentDTO("Aproveite!", sdf.parse("22/03/2018"), new AuthorDTO(bob));
        CommentDTO comment3 = new CommentDTO("Tenha um ótimo dia!", sdf.parse("23/03/2018"), new AuthorDTO(alex));
        //
        post1.getComments().addAll(Arrays.asList(comment1, comment2));
        post2.getComments().add(comment3);
        //
        postRepository.saveAll(Arrays.asList(post1, post2));
        //
        maria.getPosts().addAll(Arrays.asList(post1, post2));
        userRepository.save(maria);
        //

    }
}
