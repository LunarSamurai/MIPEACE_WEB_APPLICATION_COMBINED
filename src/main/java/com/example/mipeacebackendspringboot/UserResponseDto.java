package com.example.mipeacebackendspringboot;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Table(name="user_response")
@Entity
public class UserResponseDto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "cacID")
    private String cacID;

    @Column(name = "text_file_name")
    private String textFileName;

    @Column(name = "question_content")
    private String questionContent;

    @Column(name = "positive_or_negative")
    private String positiveOrNegative;

    @Column(name = "answer")
    private String answer; 
    
    @Column (name= "response_id")
    private String response_id;

    public Long getId() {
        return id;
    }
    public UserResponseDto() {
    }

    public String getCacID() {
        return cacID;
    }

    public void setCacID(String cacID) {
        this.cacID = cacID;
    }
    
    public String getTextFileName(){
        return textFileName;
    }

    public void setTextFileName(String textFileName){
        this.textFileName = textFileName;
    }

    public String getQuestionContent(){
        return questionContent;
    }    

    public void setQuestionContent(String questionContent){
        this.questionContent = questionContent;
    }

    public String getPositiveOrNegative(){
        return positiveOrNegative;
    }

    public void setPositiveOrNegative(String positiveOrNegative){
        this.positiveOrNegative = positiveOrNegative;
    }

    public String getAnswer(){
        return answer;
    }

    public void setAnswer(String answer){
        this.answer = answer;
    }

    public String getResponseID(){
        return response_id;
    }

    public void setResponseID(String response_id){
        this.response_id = response_id;
    }
    
}
