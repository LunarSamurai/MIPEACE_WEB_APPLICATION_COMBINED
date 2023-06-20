package com.example.mipeacebackendspringboot;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity // This tells Hibernate to make a table out of this class
@Table(name = "user_response")

public class TestResponse{
  @Id
  @GeneratedValue(strategy=GenerationType.IDENTITY)
  private Long id;

  @OneToOne
  @JoinColumn(name = "user_response_cacID")
  private User newUser;

  @Column(name = "cacID")
  private String cacID;

  @Column(name = "ScaleName")
  private String scaleName;

  @Column(name = "QuestionID")
  private Integer questionID;

  @Column(name = "Response")
  private String questionResponse;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getCACID() {
    return cacID;
  }

  public void setCACID(String cacID) {
    this.cacID = cacID;
  }

  public String getScaleName() {
    return scaleName;
  }

  public void setScaleName(String scaleName) {
    this.scaleName = scaleName;
  }

    public Integer getQuestionID() {
    return questionID;
  }

  public void setQuestionID(Integer questionID) {
    this.questionID = questionID;
  }

  public String getQuestionResponse() {
    return questionResponse;
  }

  public void setQuestionResponse(String questionResponse) {
    this.questionResponse = questionResponse;
  }

  public void setUser(User user){
    this.newUser = user;

  }
}