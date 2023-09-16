package com.kounterr.kounterrapi.entity;

import java.math.BigInteger;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

@Entity
@Table(name = "activity")
public class CounterEntity {
    // fields
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private int id;

    @Column(name = "Article ID")
    private String articleId;

    @Column(name = "Init Time")
    private String initTime;

    @Column(name = "Start Time")
    private String startTime;

    @Column(name = "End Time")
    private String endTime;

    @Column(name = "Ticks", columnDefinition = "BIGINT UNSIGNED")
    private BigInteger ticks;

    // constructors
    public CounterEntity() {} // default constructor
    public CounterEntity(String articleId, String initTime, String startTime, String endTime, BigInteger ticks) {
        this.articleId = articleId;
        this.initTime = initTime;
        this.startTime = startTime;
        this.endTime = endTime;
        this.ticks = ticks;
    }

    // getters and setters
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getArticleId() {
        return articleId;
    }
    public void setArticleId(String articleId) {
        this.articleId = articleId;
    }
    public String getInitTime() {
        return initTime;
    }
    public void setInitTime(String initTime) {
        this.initTime = initTime;
    }
    public String getStartTime() {
        return startTime;
    }
    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }
    public String getEndTime() {
        return endTime;
    }
    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }
    public BigInteger getTicks() {
        return ticks;
    }
    public void setTicks(BigInteger ticks) {
        this.ticks = ticks;
    }


    @Override
    public String toString() {
        return "CounterEntity [id=" + id + ", articleId=" + articleId + ", initTime=" + initTime + ", startTime="
                + startTime + ", endTime=" + endTime + ", ticks=" + ticks + "]";
    }
}
