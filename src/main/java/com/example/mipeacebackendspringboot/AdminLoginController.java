package com.example.mipeacebackendspringboot;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AdminLoginController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/api/admin-login")
    public ResponseEntity<?> adminLogin(@RequestParam("cacid") String cacid) {
        // Retrieve the admin user from the database based on the CAC ID
        User admin = userRepository.findByCacid("0000000001");

        if (admin != null && admin.getCACID().equals(cacid)) {
            String firstName = admin.getFirstName();
            String middleName = admin.getMiddleName();
            String lastName = admin.getLastName();

            // Create a map with the admin information
            Map<String, String> adminInfo = new HashMap<>();
            adminInfo.put("firstName", firstName);
            adminInfo.put("middleName", middleName);
            adminInfo.put("lastName", lastName);

            try {
                // Convert the adminInfo map to JSON string
                ObjectMapper objectMapper = new ObjectMapper();
                String json = objectMapper.writeValueAsString(adminInfo);

                // Return the JSON response
                return ResponseEntity.ok().body(json);
            } catch (JsonProcessingException e) {
                e.printStackTrace();
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error converting to JSON");
            }
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid admin credentials");
        }
    }

}
