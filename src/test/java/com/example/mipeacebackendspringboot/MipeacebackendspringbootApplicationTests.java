package com.example.mipeacebackendspringboot;

import java.util.Random;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MipeacebackendspringbootApplicationTests {

	@Autowired
    private UserRepository userRepository;

    @Test
    public void testCreateUsers() {
        for (int i = 0; i < 4; i++) {
            String firstName = "First" + i;
            String middleName = "Middle" + i;
            String lastName = "Last" + i;
            String cacID = generateRandomCacID();

            User n = new User();
			n.setId(n.getId());
			n.setFirstName(firstName);
			n.setMiddleName(middleName);
			n.setLastName(lastName);
			n.setCACID(cacID);
            userRepository.save(n);
			System.out.println("Test was Saved");
        }
    }

	public void testCreateTestResponse(){
        for (int i = 0; i < 4; i++) {
            String firstName = "First" + i;
            String middleName = "Middle" + i;
            String lastName = "Last" + i;
            String cacID = generateRandomCacID();

            User n = new User();
			n.setId(n.getId());
			n.setFirstName(firstName);
			n.setMiddleName(middleName);
			n.setLastName(lastName);
			n.setCACID(cacID);
            userRepository.save(n);
			System.out.println("Test was Saved");
        }		
	}

    private String generateRandomCacID() {
        Random random = new Random();
        StringBuilder cacIDBuilder = new StringBuilder();

        for (int i = 0; i < 10; i++) {
            int digit = random.nextInt(10);
            cacIDBuilder.append(digit);
        }

        return cacIDBuilder.toString();
    }
}

