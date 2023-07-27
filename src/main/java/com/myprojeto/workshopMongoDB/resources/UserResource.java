package com.myprojeto.workshopMongoDB.resources;

import com.myprojeto.workshopMongoDB.domain.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

    @GetMapping
    public ResponseEntity<List<User>> findAll(){
        List<User> list = Arrays.asList(new User(1L, "Jose Brown", "jose@gmail.com"),
                new User(2L, "Maria Blue", "maria@gmail.com"));
        return ResponseEntity.ok().body(list);
    }
}
