package com.example.mipeacebackendspringboot;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MipeacebackendspringbootApplicationTests {

    @Autowired
    private UserRepository userRepository;

    /*@Test
    public void testCreateUsers() {
        for (int i = 0; i < 4; i++) {
            String firstName = "First" + i;
            String middleName = "Middle" + i;
            String lastName = "Last" + i;
            String cacID = generateRandomCacID();

            User n = new User();
            n.setFirstName(firstName);
            n.setMiddleName(middleName);
            n.setLastName(lastName);
            n.setCACID(cacID);
            userRepository.save(n);
            System.out.println("User was Saved: " + n);
        }
    }

    private String generateRandomCacID() {
        // Your implementation for generating the CACID
        // (I assume you have this logic already, and it is working fine)
        return "GeneratedCACID";
    }*/
}
