package com.example.mipeacebackendspringboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class TestOrderService {

    private final TestOrderRepository testOrderRepository;

    @Autowired
    public TestOrderService(TestOrderRepository testOrderRepository) {
        this.testOrderRepository = testOrderRepository;
    }

    public List<TestOrder> getAllTestOrders() {
        return testOrderRepository.findAll();
    }

    public void saveTestOrder(TestOrderDto testOrderDto) {
        
        int testOrderNumber = testOrderDto.getTestOrderNumber();
        String textFileName = testOrderDto.getTextFileName();

        TestOrder testOrder = new TestOrder(testOrderNumber, textFileName);
        testOrderRepository.save(testOrder);
    }
    public void deleteAllTestOrders() {
        testOrderRepository.deleteAll();
    }
}


