package com.myprojeto.workshopMongoDB.service;

import com.myprojeto.workshopMongoDB.domain.Post;
import com.myprojeto.workshopMongoDB.repositories.PostRepository;
import com.myprojeto.workshopMongoDB.service.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PostService {

    @Autowired
    private PostRepository repository;

    public Post findById(String id){
        Optional<Post> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Post não encontrado"));
    }
}
