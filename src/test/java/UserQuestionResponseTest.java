import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.example.mipeacebackendspringboot.MainController;
import com.example.mipeacebackendspringboot.TestController;
import com.example.mipeacebackendspringboot.TestResponse;
import com.example.mipeacebackendspringboot.TestResponseRepository;
import com.example.mipeacebackendspringboot.User;
import com.example.mipeacebackendspringboot.UserRepository;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

class UserQuestionResponseTest {

    @Mock
    private UserRepository userRepository;

    @Mock
    private TestResponseRepository testResponseRepository;

    @InjectMocks
    private MainController mainController;

    @InjectMocks
    private TestController testController;

    @BeforeEach
    void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testAddNewUser() {
        // Mock the userRepository.save() method
        when(userRepository.save(any(User.class))).thenReturn(new User());

        // Call the addNewUser() method with test data
        String firstName = "John";
        String middleName = "Doe";
        String lastName = "Smith";
        String cacID = "123456";
        mainController.addNewUser(firstName, middleName, lastName, cacID);

        // Verify that userRepository.save() was called with the correct parameters
        verify(userRepository).save(argThat(user ->
                user.getFirstName().equals(firstName) &&
                user.getMiddleName().equals(middleName) &&
                user.getLastName().equals(lastName) &&
                user.getCACID().equals(cacID)
        ));
    }

    @Test
    void testSubmitTestResponses() {
        // Mock the userRepository.findByCacID() method
        User user = new User();
        when(userRepository.findByCacid(anyString())).thenReturn(user);

        // Mock the testResponseRepository.save() method
        when(testResponseRepository.save(any(TestResponse.class))).thenReturn(new TestResponse());

        // Create test data
        String cacID = "123456";

        User newUser = new User();
        user.setCACID(cacID);
        List<TestResponse> responses = new ArrayList<>(); // Create the responses list


        TestResponse response1 = new TestResponse();
        response1.setUser(user);
        response1.setScaleName("Scale 1");
        response1.setQuestionID(1);
        response1.setQuestionResponse("Response 1");
        responses.add(response1);

        TestResponse response2 = new TestResponse();
        response2.setUser(user);
        response2.setScaleName("Scale 2");
        response2.setQuestionID(2);
        response2.setQuestionResponse("Response 2");
        responses.add(response2);

        // Call the submitTestResponses() method
        testController.submitTestResponses(cacID, responses);

        // Verify that userRepository.findByCacID() was called with the correct parameter
        verify(userRepository).findByCacid(cacID);

        // Verify that testResponseRepository.save() was called for each response
        verify(testResponseRepository, times(responses.size())).save(any(TestResponse.class));
    }
}
