package com.myprojeto.workshopMongoDB.repositories;

import com.myprojeto.workshopMongoDB.domain.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<User, String> {
}
