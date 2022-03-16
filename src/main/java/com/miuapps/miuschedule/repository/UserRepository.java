package com.miuapps.miuschedule.repository;

import com.miuapps.miuschedule.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

/**
 * The interface User repository.
 */
public interface UserRepository extends MongoRepository<User, String> {
    /**
     * Find by username optional.
     *
     * @param username the username
     * @return the optional
     */
    Optional<User> findByUsername(String username);

    /**
     * Exists by username boolean.
     *
     * @param username the username
     * @return the boolean
     */
    Boolean existsByUsername(String username);

    /**
     * Exists by email boolean.
     *
     * @param email the email
     * @return the boolean
     */
    Boolean existsByEmail(String email);

    /**
     * Find user by id user.
     *
     * @param userId the user id
     * @return the user
     */
    User findUserById(String userId);

}