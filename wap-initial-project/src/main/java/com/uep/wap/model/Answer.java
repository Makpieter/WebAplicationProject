package com.uep.wap.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="answers")
public class Answer {
    @Id
    @Column(name ="id")
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name ="description")
    private String description;
    @Column(name ="author")
    private User author;
    @Column(name ="createdAt")
    private Date createdAt;
    @Column(name ="updatedAt")
    private Date updatedAt;
    @Column(name ="votes")
    private Integer votes;
    @Column(name ="isAccepted")
    private Boolean isAccepted;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
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

    public Integer getVotes() {
        return votes;
    }

    public void setVotes(Integer votes) {
        this.votes = votes;
    }

    public Boolean getAccepted() {
        return isAccepted;
    }

    public void setAccepted(Boolean accepted) {
        isAccepted = accepted;
    }

    public Answer(){

    }
}


