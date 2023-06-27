package com.example.mipeacebackendspringboot;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Table(name="test_order")
@Entity
public class TestOrderDto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "test_order_number")
    private int testOrderNumber;

    @Column(name = "text_file_name")
    private String textFileName;

    public Long getId() {
        return id;
    }
    public TestOrderDto() {
    }

    public int getTestOrderNumber(){
        return testOrderNumber;
    }
    
    public void setTestOrderNumber(int testOrderNumber){
        this.testOrderNumber = testOrderNumber;
    }
    
    public String getTextFileName(){
        return textFileName;
    }

    public void setTextFileName(String textFileName){
        this.textFileName = textFileName;
    }
}
