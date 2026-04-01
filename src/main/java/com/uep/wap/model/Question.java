package com.uep.wap.model;

import com.uep.wap.dto.QuestionStatus;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name="questions")
public class Question {
    @Id
    @Column(name ="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name ="title")
    private String title;

    @Column(name ="description")
    private String description;

    @Column(name ="tags")
    private Set<Tag> tags;

    @ManyToOne
    @JoinColumn(name ="author")
    private User author;

    @Column(name ="createdAt")
    private Date createdAt;

    @Column(name ="updatedAt")
    private Date updatedAt;

    @Enumerated(EnumType.STRING)
    @Column(name ="status")
    private QuestionStatus status;

    @OneToOne
    @JoinColumn(name ="acceptedAnswer")
    private Answer acceptedAnswer;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set getTags() {
        return tags;
    }

    public void setTags(Set tags) {
        this.tags = tags;
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

    public QuestionStatus getStatus() {
        return status;
    }

    public void setStatus(QuestionStatus status) {
        this.status = status;
    }

    public Answer getAcceptedAnswer() {
        return acceptedAnswer;
    }

    public void setAcceptedAnswer(Answer acceptedAnswer) {
        this.acceptedAnswer = acceptedAnswer;
    }

    public Question(){

    }
}


