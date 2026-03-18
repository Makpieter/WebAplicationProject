package com.uep.wap.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="students")
public class User {
    @Id
    @Column(name ="id")
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name ="username")
    private String username;
    @Column(name ="email")
    private String email;
    @Column(name ="password")
    private String password;
    @Column(name ="role")
    private Enum role;
    @Column(name ="reputation")
    private Integer reputation;
    @Column(name ="bio")
    private String bio;
    @Column(name ="status")
    private Enum status;
    @Column(name ="createdAt")
    private Date createdAt;
    @Column(name ="updatedAt")
    private Date updatedAt;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Enum getRole() {
        return role;
    }

    public void setRole(Enum role) {
        this.role = role;
    }

    public Integer getReputation() {
        return reputation;
    }

    public void setReputation(Integer reputation) {
        this.reputation = reputation;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public Enum getStatus() {
        return status;
    }

    public void setStatus(Enum status) {
        this.status = status;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    ///

    public User(){

    }

    public void getProfile(){
        System.out.println("Username: "+ getUsername());
        System.out.println("Biography: "+ getBio());
        System.out.println("Reputation score: "+ getReputation());
        System.out.println("Posted Questions:");
        System.out.println("Answered Questions:");
        System.out.println("Activity History:");
        System.out.println("Bookmarked Questions:");
    }
    public void updateProfile(){

    }
    public void addReputation(){

    }
    public void suspend(){

    }
}


