package com.zsc.museum.domain;

/*
外借实体类  用于存储文物的外借信息
*/

public class Borrow {
    Long cultural_relic_id; //文物编号
    String to_who;          //外借名称

    public Long getCultural_relic_id() {
        return cultural_relic_id;
    }

    public void setCultural_relic_id(Long cultural_relic_id) {
        this.cultural_relic_id = cultural_relic_id;
    }

    public String getTo_who() {
        return to_who;
    }

    public void setTo_who(String to_who) {
        this.to_who = to_who;
    }
}
