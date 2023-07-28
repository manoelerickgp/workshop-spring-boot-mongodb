package com.myprojeto.workshopMongoDB.resources;

import com.myprojeto.workshopMongoDB.domain.User;
import com.myprojeto.workshopMongoDB.dto.UserDTO;
import com.myprojeto.workshopMongoDB.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    private UserService service;

    @GetMapping
    public ResponseEntity<List<UserDTO>> findAll(){
        List<User> list = service.findAll();
        List<UserDTO> listDTO = list.stream().map(u -> new UserDTO(u)).toList();
        return ResponseEntity.ok().body(listDTO);
    }
}
