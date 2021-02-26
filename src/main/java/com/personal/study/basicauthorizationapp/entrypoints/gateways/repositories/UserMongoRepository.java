package com.personal.study.basicauthorizationapp.entrypoints.gateways.repositories;

import com.personal.study.basicauthorizationapp.entrypoints.gateways.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class UserMongoRepository {

    @Autowired
    private MongoOperations mongoOperations;

    public Optional<User> findByUsername(final String username) {
        final Query query = new Query();
        query.addCriteria(Criteria.where("username").is(username));

        return Optional.ofNullable(mongoOperations.findOne(query, User.class));
    }


    public void createUser(final User user) {
        mongoOperations.insert(user);
    }

}
