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

    @Column(name = "cacid")
    private int cacid;

    @Column(name = "text_file_name")
    private String textFileName;

    @Column(name = "question_content")
    private String questionContent;

    @Column(name = "positive_or_negative")
    private String positiveOrNegative;

    @Column(name = "answer")
    private String answer;    

    public Long getId() {
        return id;
    }
    public UserResponseDto() {
    }

    public int getcacid(){
        return cacid;
    }
    
    public void setcacid(int cacid){
        this.cacid = cacid;
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
    
}
