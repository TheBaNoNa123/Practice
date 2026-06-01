package com.register.code;

import org.springframework.data.jpa.repository.JpaRepository;

public interface Repository extends JpaRepository<userEntity, Integer> {
}
