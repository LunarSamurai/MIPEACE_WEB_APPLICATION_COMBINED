// Example service class in Spring Boot
package com.example.mipeacebackendspringboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegistrationService {

    @Autowired
    private UserRepository userRepository;

    public void saveRegistrationData(User newUser) {
        // Save the registrationData to the database using the registrationRepository
        userRepository.save(newUser);
    }

}
