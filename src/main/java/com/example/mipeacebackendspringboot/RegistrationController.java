// Example controller class in Spring Boot
package com.example.mipeacebackendspringboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class RegistrationController {

  @Autowired
  private RegistrationService registrationService;

  @PostMapping("/register")
  public ResponseEntity<String> registerUser(@RequestBody User newUser) {
    // Save the registrationData to the database using your service or repository class
    registrationService.saveRegistrationData(newUser);
    // Return a response indicating the success of the operation
    return ResponseEntity.ok("Registration successful");
  }
}
