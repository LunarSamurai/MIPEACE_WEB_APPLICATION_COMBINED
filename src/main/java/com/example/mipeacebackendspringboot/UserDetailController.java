package com.example.mipeacebackendspringboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/userdetails")
public class UserDetailController {

    @Autowired
    private UserDetailRepository userDetailRepository;

    @PostMapping("/update")
    public ResponseEntity<Map<String, String>> updateUserDetails(@RequestBody UserDetail userDetails) {
        // Find the existing record based on cacId
        UserDetail existingUserDetail = userDetailRepository.findByCacID(userDetails.getCacID())
        .orElseGet(() -> {
            UserDetail newUserDetail = new UserDetail();
            newUserDetail.setCacID(userDetails.getCacID());
            return newUserDetail;
        });

        existingUserDetail.setDutyStatus(userDetails.getDutyStatus());
        existingUserDetail.setAge(userDetails.getAge());
        existingUserDetail.setMaritalStatus(userDetails.getMaritalStatus());
        existingUserDetail.setGrade(userDetails.getGrade());
        existingUserDetail.setSex(userDetails.getSex());
        existingUserDetail.setHandedness(userDetails.getHandedness());
        existingUserDetail.setHeight(userDetails.getHeight());
        existingUserDetail.setWeight(userDetails.getWeight());
        existingUserDetail.setMilitaryOccupationalSpeciality(userDetails.getMilitaryOccupationalSpeciality());
        existingUserDetail.setSiblingsCount(userDetails.getSiblingsCount());

        userDetailRepository.save(existingUserDetail);

        Map<String, String> response = new HashMap<>();
        response.put("message", "User details updated successfully");
        return ResponseEntity.ok(response);
    }
}
