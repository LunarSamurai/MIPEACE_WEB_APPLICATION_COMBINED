package com.example.mipeacebackendspringboot;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Table(name="test_order")
@Entity

public class TestOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "test_order_number")
    private int testOrderNumber;

    @Column(name = "text_file_name")
    private String textFileName;


    public TestOrder() {
    }

    public TestOrder(int testOrderNumber, String textFileName) {
        this.testOrderNumber = testOrderNumber;
        this.textFileName = textFileName;
    }

    // Getters and Setters

    public Long getId() {
        return id;
    }

    public int getTestOrderNumber() {
        return testOrderNumber;
    }

    public void setTestOrderNumber(int testOrderNumber) {
        this.testOrderNumber = testOrderNumber;
    }

    public String getTextFileName() {
        return textFileName;
    }

    public void setTextFileName(String textFileName) {
        this.textFileName = textFileName;
    }
}

