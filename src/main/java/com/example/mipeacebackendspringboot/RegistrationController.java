// Example controller class in Spring Boot
package com.example.mipeacebackendspringboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class RegistrationController {

    @Autowired
    private RegistrationService registrationService;

    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody User newUser) {
        // Save the registrationData to the database using your service or repository
        // class
        registrationService.saveRegistrationData(newUser);
        // Return a response indicating the success of the operation
        return ResponseEntity.ok("Registration successful");
    }

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/admin-login")
    public ResponseEntity<?> adminLogin(@RequestParam("cacid") String cacid) {
        // Retrieve the admin user from the database based on the CAC ID
        User admin = userRepository.findByCacID(cacid);

        if (admin != null) {
            String firstName = admin.getFirstName();
            String middleName = admin.getMiddleName();
            String lastName = admin.getLastName();
            System.out.println("Pull has been made");
            return ResponseEntity.ok().body("Admin login successful. First Name: " + firstName +
                    ", Middle Name: " + middleName + ", Last Name: " + lastName);
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid admin credentials");
        }
    }

}
