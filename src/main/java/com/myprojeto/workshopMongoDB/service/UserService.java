package com.myprojeto.workshopMongoDB.service;

import com.myprojeto.workshopMongoDB.domain.User;
import com.myprojeto.workshopMongoDB.dto.UserDTO;
import com.myprojeto.workshopMongoDB.repositories.UserRepository;
import com.myprojeto.workshopMongoDB.service.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public List<User> findAll(){
        return repository.findAll();
    }

    public User findById(String id){
        Optional<User> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
    }

    public User insert(User obj){
        return repository.insert(obj);
    }

    public void delete(String id) {
        User obj = findById(id);
        repository.delete(obj);
    }

    public User fromDTO(UserDTO objDTO){
        return new User(objDTO.getId(), objDTO.getName(), objDTO.getEmail());
    }
}
