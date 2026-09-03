package com.jurisai.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "source")
public class Source {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "answer_id", nullable = false)
    private Answer answer;

    @Column(nullable = false)
    private String title;

    @Column(length = 255)
    private String article;

    @Column(columnDefinition = "TEXT")
    private String reference;

    public Source() {}

    // Getters e Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Answer getAnswer() { return answer; }
    public void setAnswer(Answer answer) { this.answer = answer; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getArticle() { return article; }
    public void setArticle(String article) { this.article = article; }

    public String getReference() { return reference; }
    public void setReference(String reference) { this.reference = reference; }
}