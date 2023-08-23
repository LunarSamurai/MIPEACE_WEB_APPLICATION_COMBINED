package com.example.mipeacebackendspringboot;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "user_details")
public class UserDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "cac_id", unique = true, nullable = false)
    private String cacID;

    @Column(name = "duty_status")
    private String dutyStatus;

    @Column(name = "age")
    private String age;

    @Column(name = "marital_status")
    private String maritalStatus;

    @Column(name = "grade")
    private String grade;

    @Column(name = "sex")
    private String sex;

    @Column(name = "handedness")
    private String handedness;

    @Column(name = "height")
    private String height;

    @Column(name = "weight")
    private String weight;

    @Column(name = "military_occupational_speciality")
    private String militaryOccupationalSpeciality;

    @Column(name = "siblings_count")
    private String siblingsCount;

    // Standard getters and setters for each field
        // Getter and Setter for id
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    // Getter and Setter for cacId
    public String getCacID() {
        return cacID;
    }

    public void setCacID(String cacID) {
        this.cacID = cacID;
    }
    // Getter and Setter for dutyStatus
    public String getDutyStatus() {
        return dutyStatus;
    }

    public void setDutyStatus(String dutyStatus) {
        this.dutyStatus = dutyStatus;
    }

    // Getter and Setter for age
    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    // Getter and Setter for maritalStatus
    public String getMaritalStatus() {
        return maritalStatus;
    }

    public void setMaritalStatus(String maritalStatus) {
        this.maritalStatus = maritalStatus;
    }

    // Getter and Setter for grade
    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    // Getter and Setter for sex
    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    // Getter and Setter for handedness
    public String getHandedness() {
        return handedness;
    }

    public void setHandedness(String handedness) {
        this.handedness = handedness;
    }

    // Getter and Setter for height
    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    // Getter and Setter for weight
    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    // Getter and Setter for militaryOccupationalSpeciality
    public String getMilitaryOccupationalSpeciality() {
        return militaryOccupationalSpeciality;
    }

    public void setMilitaryOccupationalSpeciality(String militaryOccupationalSpeciality) {
        this.militaryOccupationalSpeciality = militaryOccupationalSpeciality;
    }

    // Getter and Setter for siblingsCount
    public String getSiblingsCount() {
        return siblingsCount;
    }

    public void setSiblingsCount(String siblingsCount) {
        this.siblingsCount = siblingsCount;
    }

}
