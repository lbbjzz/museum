package com.zsc.museum.domain;

/*
外借实体类  用于存储文物的外借信息
*/

public class Borrow {
    Long borrowId;        //外借主键
    Long culturalRelicId; //文物编号
    String toWho;           //外借名称
    String borrowTime;      //借出时间

    public Long getCulturalRelicId() {
        return culturalRelicId;
    }

    public void setCulturalRelicId(Long culturalRelicId) {
        this.culturalRelicId = culturalRelicId;
    }

    public String getToWho() {
        return toWho;
    }

    public void setToWho(String toWho) {
        this.toWho = toWho;
    }

    public String getBorrowTime() {
        return borrowTime;
    }

    public void setBorrowTime(String borrowTime) {
        this.borrowTime = borrowTime;
    }

    public Long getBorrowId() {
        return borrowId;
    }

    public void setBorrowId(Long borrowId) {
        this.borrowId = borrowId;
    }
}
