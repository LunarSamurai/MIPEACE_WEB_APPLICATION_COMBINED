package com.example.mipeacebackendspringboot;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.MediaType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.core.io.Resource;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;


@RestController
@RequestMapping("/api")
public class TestOrderController {

    private final TestOrderService testOrderService;

    @Autowired
    public TestOrderController(TestOrderService testOrderService) {
        this.testOrderService = testOrderService;
    }

    @GetMapping("/get-test-order")
    public ResponseEntity<List<TestOrderDto>> getTestOrders() {
        System.out.println("/api/get-test-order was found and used!");
        List<TestOrder> testOrders = testOrderService.getAllTestOrders();
        List<TestOrderDto> testOrderDtos = testOrders.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
        return ResponseEntity.ok(testOrderDtos);
    }
    
    @GetMapping("/get-test-file")
    public ResponseEntity<String> getTestFile(@RequestParam("fileName") String fileName) throws IOException {
        System.out.println("The /get-test-file mapping was found!");
        String filePath = "QuestionsFiles/" + fileName;
        System.out.println(filePath);
        System.out.println(fileName);
        InputStream inputStream = getClass().getClassLoader().getResourceAsStream(filePath);

        if (inputStream != null) {
            String fileContents = new String(inputStream.readAllBytes(), StandardCharsets.UTF_8);
            inputStream.close();
            System.out.println("File Contents were read: " + fileContents);
            return ResponseEntity
                    .ok()
                    .contentType(MediaType.TEXT_PLAIN)
                    .body(fileContents);
        } else {
            System.out.println("Your code is not working");
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body(null);
        }
    }

    @GetMapping("/get-file-names")
    public ResponseEntity<List<String>> getFileNames() throws IOException {
        String directoryPath = "QuestionsFiles";
        Resource resource = new ClassPathResource(directoryPath);
        File directory = resource.getFile();
        List<String> fileNames = Files.walk(directory.toPath())
                .filter(Files::isRegularFile)
                .map(Path::getFileName)
                .map(Path::toString)
                .collect(Collectors.toList());
        return ResponseEntity.ok(fileNames);
    }

    @PostMapping("/upload-file")
    public ResponseEntity<String> uploadFile(@RequestParam("file") MultipartFile file) {
        String uploadDirectory = "QuestionsFiles"; // Specify the directory to upload the file
        String fileName = file.getOriginalFilename();
        System.out.println(fileName);
        try {
            // Create the directory if it does not exist
            File directory = new File(uploadDirectory);
            if (!directory.exists()) {
                directory.mkdirs();
            }

            // Copy the file to the upload directory
            Files.copy(file.getInputStream(), Path.of(uploadDirectory, fileName), StandardCopyOption.REPLACE_EXISTING);
            System.out.println("Will be attempting upload...");
            return ResponseEntity.ok("File uploaded successfully");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Looks like it isnt working...");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to upload the file");
        }
    }

    private TestOrderDto convertToDto(TestOrder testOrder) {
        TestOrderDto testOrderDto = new TestOrderDto();
        // Set the properties of testOrderDto based on testOrder
        testOrderDto.setTestOrderNumber(testOrder.getTestOrderNumber());
        testOrderDto.setTextFileName(testOrder.getTextFileName());
        // Set other properties as needed
        return testOrderDto;
    }
    
    @PostMapping("/test-order")
    public ResponseEntity<String> saveTestOrder(@RequestBody TestOrderDto testOrderDto) {
        testOrderService.saveTestOrder(testOrderDto);
        return ResponseEntity.ok("Test order saved successfully");
    }

    @DeleteMapping("/test-order")
    public ResponseEntity<String> deleteAllTestOrders() {
        testOrderService.deleteAllTestOrders();
        return ResponseEntity.ok("All test orders deleted successfully");
    }

    @PostMapping("/save-user-responses")
    public ResponseEntity<String> saveUserResponses(@RequestBody List<UserResponseDto> userResponses) {
        testOrderService.saveUserResponses(userResponses);
        return ResponseEntity.ok("User responses saved successfully");
    }
}



