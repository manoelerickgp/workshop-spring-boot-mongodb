package com.myprojeto.workshopMongoDB.resources;

import com.myprojeto.workshopMongoDB.domain.User;
import com.myprojeto.workshopMongoDB.dto.UserDTO;
import com.myprojeto.workshopMongoDB.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
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

    @GetMapping(value ="/{id}")
    public ResponseEntity<UserDTO> findById(@PathVariable String id) {
        User user = service.findById(id);
        return ResponseEntity.ok().body(new UserDTO(user));
    }

    @PostMapping
    public ResponseEntity<Void> insert(@RequestBody UserDTO objDTO){
        User obj = service.fromDTO(objDTO);
        obj = service.insert(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @DeleteMapping(value = "/{juvenal}")
    public ResponseEntity<Void> delete(@PathVariable String juvenal) {
        service.delete(juvenal);
        return ResponseEntity.noContent().build();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<User> update(@PathVariable String id, @RequestBody UserDTO objDTO){
        User newUser = service.fromDTO(objDTO);
        newUser = service.update(id, newUser);
        return ResponseEntity.ok().body(newUser);
    }
}
