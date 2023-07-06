package com.example.mipeacebackendspringboot;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserResponseRepository extends JpaRepository<UserResponseDto, Long> {
    // Add custom query methods if needed

}