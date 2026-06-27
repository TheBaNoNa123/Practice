package com.register.code;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface Repository extends JpaRepository<userEntity, Integer> {
    Optional<userEntity> findByName(String name);
    boolean existsByName(String name);

}
