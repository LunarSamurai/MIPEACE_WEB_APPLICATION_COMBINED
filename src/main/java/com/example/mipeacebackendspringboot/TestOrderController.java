package com.example.mipeacebackendspringboot;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class TestOrderController {

    private final TestOrderService testOrderService;

    @Autowired
    public TestOrderController(TestOrderService testOrderService) {
        this.testOrderService = testOrderService;
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



