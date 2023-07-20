package com.example.mipeacebackendspringboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TestOrderService {

    private final TestOrderRepository testOrderRepository;
    private final UserResponseRepository userResponseRepository;

    @Autowired
    public TestOrderService(TestOrderRepository testOrderRepository, UserResponseRepository userResponseRepository) {
        this.testOrderRepository = testOrderRepository;
        this.userResponseRepository = userResponseRepository;
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
        userResponseRepository.saveAll(entities);
    }

    private UserResponseDto convertToEntity(UserResponseDto dto) {
        UserResponseDto entity = new UserResponseDto();
        entity.setCacID(dto.getCacID());
        entity.setTextFileName(dto.getTextFileName());
        entity.setQuestionContent(dto.getQuestionContent());
        entity.setPositiveOrNegative(dto.getPositiveOrNegative());
        entity.setAnswer(dto.getAnswer());
        entity.setResponseID(dto.getResponseID());
        // Set other properties as needed
        return entity;
    }


}


