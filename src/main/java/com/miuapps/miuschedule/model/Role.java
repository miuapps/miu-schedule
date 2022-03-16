package com.miuapps.miuschedule.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Role)) return false;
        Role role = (Role) o;
        return name == role.name;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}