package com.Finance.Tracker;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface Repository extends JpaRepository<Entity, Integer> {
    //boolean would be more efficient
    Optional<Entity> findByCategoryAndAmountAndDate(String category, float amount, String date);

}
