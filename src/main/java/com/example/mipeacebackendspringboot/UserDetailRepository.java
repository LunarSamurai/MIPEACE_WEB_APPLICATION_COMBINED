package com.example.mipeacebackendspringboot;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface UserDetailRepository extends JpaRepository<UserDetail, Long> {

    Optional<UserDetail> findByCacID(String cacID);
}
