package com.miuapps.miuschedule.repository;

import com.miuapps.miuschedule.model.ERole;
import com.miuapps.miuschedule.model.Role;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

/**
 * The interface Role repository.
 */
public interface RoleRepository extends MongoRepository<Role, String> {
    /**
     * Find by name optional.
     *
     * @param name the name
     * @return the optional
     */
    Optional<Role> findByName(ERole name);
}