package com.zsc.museum.domain;

/*
归还实体类  用于存储文物的归还信息
*/

public class Return {
    Long returnId;         //归还主键
    Long culturalRelicId; //文物编号
    String forWho;           //归还单位
    String borrowTime;         //借出时间
    String returnTime;      //归还时间

    public Long getCulturalRelicId() {
        return culturalRelicId;
    }

    public void setCulturalRelicId(Long culturalRelicId) {
        this.culturalRelicId = culturalRelicId;
    }

    public String getForWho() {
        return forWho;
    }

    public void setForWho(String forWho) {
        this.forWho = forWho;
    }

    public String getBorrowTime() {
        return borrowTime;
    }

    public void setBorrowTime(String borrowTime) {
        this.borrowTime = borrowTime;
    }

    public String getReturnTime() {
        return returnTime;
    }

    public void setReturnTime(String returnTime) {
        this.returnTime = returnTime;
    }

    public Long getReturnId() {
        return returnId;
    }

    public void setReturnId(Long returnId) {
        this.returnId = returnId;
    }
}
