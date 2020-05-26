package com.zsc.museum.domain;

/*
离馆登记实体类  用于存储文物的离馆信息
*/

public class Out_library {
    Long cultural_relic_id;  //文物编号
    String to_where;         //离馆去处

    public Long getCultural_relic_id() {
        return cultural_relic_id;
    }

    public void setCultural_relic_id(Long cultural_relic_id) {
        this.cultural_relic_id = cultural_relic_id;
    }

    public String getTo_where() {
        return to_where;
    }

    public void setTo_where(String to_where) {
        this.to_where = to_where;
    }
}
