package com.example.mipeacebackendspringboot;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

public interface TestResponseRepository extends CrudRepository<TestResponse, Long> {
    List<TestResponse> findByCacID(String cacID);
}
