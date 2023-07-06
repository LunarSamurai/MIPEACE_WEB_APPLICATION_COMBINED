package com.example.mipeacebackendspringboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

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

    
    public void saveUserResponses(List<UserResponseDto> userResponses) {
        List<UserResponseDto> entities = userResponses.stream()
                .map(this::convertToEntity)
                .collect(Collectors.toList());
        
    }

    private UserResponseDto convertToEntity(UserResponseDto dto) {
        UserResponseDto entity = new UserResponseDto();
        entity.setcacid(dto.getcacid());
        entity.setTextFileName(dto.getTextFileName());
        entity.setQuestionContent(dto.getQuestionContent());
        entity.setPositiveOrNegative(dto.getPositiveOrNegative());
        entity.setAnswer(dto.getAnswer());
        // Set other properties as needed
        return entity;
    }


}


