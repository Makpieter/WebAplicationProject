package com.uep.wap.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="comments")
public class Comment {
    @Id
    @Column(name ="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name ="content")
    private String content;
    @Column(name ="author")
    private User author;
    @Column(name ="createdAt")
    private Date createdAt;
    @Column(name ="updatedAt")
    private Date updatedAt;
    @Column(name ="targetQuestion")
    private Question targetQuestion;
    @Column(name ="targetAnswer")
    private Answer targetAnswer;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
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

    public Question getTargetQuestion() {
        return targetQuestion;
    }

    public void setTargetQuestion(Question targetQuestion) {
        this.targetQuestion = targetQuestion;
    }

    public Answer getTargetAnswer() {
        return targetAnswer;
    }

    public void setTargetAnswer(Answer targetAnswer) {
        this.targetAnswer = targetAnswer;
    }

    public Comment(){

    }
    @ManyToOne
    @JoinColumn(name = "author")
    private User author;

    @ManyToOne
    @JoinColumn(name = "targetQuestion")
    private Question targetQuestion;

    @ManyToOne
    @JoinColumn(name = "targetAnswer")
    private Answer targetAnswer;
}


