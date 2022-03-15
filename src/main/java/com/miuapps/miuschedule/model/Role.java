package com.miuapps.miuschedule.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * The type Role.
 */
@Document(collection = "roles")
@Data
@NoArgsConstructor
public class Role {
    @Id
    private String id;
    private ERole name;

    /**
     * Instantiates a new Role.
     *
     * @param name the name
     */
    public Role(ERole name) {
        this.name = name;
    }
}