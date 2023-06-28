package com.example.mipeacebackendspringboot;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.MediaType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.core.io.Resource;
import java.nio.file.Path;


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
        List<TestOrder> testOrders = testOrderService.getAllTestOrders();
        List<TestOrderDto> testOrderDtos = testOrders.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
        return ResponseEntity.ok(testOrderDtos);
    }
    
    @GetMapping(value = "/get-test-file", produces = MediaType.TEXT_PLAIN_VALUE)
    public ResponseEntity<String> getTestFile(@RequestParam("fileName") String fileName) throws IOException {
        Resource resource = new ClassPathResource("QuestionFiles/" + fileName);

        if (resource.exists()) {
            Path filePath = resource.getFile().toPath();
            String fileContent = new String(Files.readAllBytes(filePath));
            return ResponseEntity.ok(fileContent);
        } else {
            return ResponseEntity.notFound().build();
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
}



