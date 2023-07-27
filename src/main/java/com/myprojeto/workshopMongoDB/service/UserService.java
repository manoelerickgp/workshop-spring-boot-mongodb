package com.myprojeto.workshopMongoDB.service;

import com.myprojeto.workshopMongoDB.domain.User;
import com.myprojeto.workshopMongoDB.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public List<User> findAll(){
        return repository.findAll();
    }
}
