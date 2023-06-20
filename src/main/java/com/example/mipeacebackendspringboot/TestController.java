package com.example.mipeacebackendspringboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;

@Controller
@RequestMapping(path = "/test")
public class TestController {

    private final UserRepository userRepository;
    private final TestResponseRepository testResponseRepository;

    public TestController(UserRepository userRepository, TestResponseRepository testResponseRepository) {
        this.userRepository = userRepository;
        this.testResponseRepository = testResponseRepository;
    }

    @Autowired
    private QuestionReader questionReader;

    @GetMapping(path = "/questions")
    public @ResponseBody
    List<Question> getTestQuestions() {
        // Retrieve the relevant questions based on the provided cacID
        String filePath = "path/to/QuestionsFiles/"; // Replace with the actual file path
        List<Question> questions;
        try {
            questions = questionReader.readQuestionsFromDirectory(filePath);
        } catch (IOException e) {
            // Handle the exception appropriately
            return Collections.emptyList(); // Return an empty list in case of an error
        }
        return questions;
    }

    @GetMapping("/files/{filename}")
    public ResponseEntity<Resource> downloadFile(@PathVariable String filename) {
        try {
            // Construct the file path
            String filePath = "path/to/QuestionsFiles/" + filename;
            File file = new File(filePath);

            // Check if the file exists
            if (file.exists()) {
                // Load the file as a resource
                Resource resource = new FileSystemResource(file);

                return ResponseEntity.ok()
                        .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + resource.getFilename() + "\"")
                        .body(resource);
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @PostMapping("/upload")
    public ResponseEntity<String> uploadFile(@RequestParam("file") MultipartFile file) {
        // Check if file is empty
        if (file.isEmpty()) {
            return ResponseEntity.badRequest().body("Please select a file to upload");
        }

        try {
            // Save the file to the storage location
            Path filePath = Paths.get("path/to/storage/directory", file.getOriginalFilename());
            Files.write(filePath, file.getBytes());

            return ResponseEntity.ok("File uploaded successfully");
        } catch (IOException e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to upload file");
        }
    }

    @PostMapping(path = "/submit")
    public @ResponseBody
    String submitTestResponses(@RequestParam String cacID, @RequestBody List<TestResponse> responses) {
        // Find the user based on cacID
        User user = userRepository.findByCacID(cacID);
        if (user == null) {
            return "User not found";
        }

        // Save the test responses associated with the user
        for (TestResponse response : responses) {
            TestResponse testResponse = new TestResponse();
            testResponse.setUser(user);
            testResponse.setScaleName(response.getScaleName());
            testResponse.setQuestionID(response.getQuestionID());
            testResponse.setQuestionResponse(response.getQuestionResponse());
            testResponseRepository.save(testResponse);
        }

        // Perform any additional processing or calculations

        return "Test responses submitted";
    }
}
