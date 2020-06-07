package com.zsc.museum.domain;

/*
文物评估实体类  用于存储文物的资产价值评估信息
*/

import java.util.Date;

public class Assessment {
    Long cultural_relic_id;   //文物编号
    Long staff_id;            //评估工号
    Long enter_library_value; //入馆价值
    Date enter_library_time;  //评估 入馆价值 时间
    Long out_library_value;   //出馆价值
    Date out_library_time;    //评估 出馆价值 时间

    public Long getCultural_relic_id() {
        return cultural_relic_id;
    }

    public void setCultural_relic_id(Long cultural_relic_id) {
        this.cultural_relic_id = cultural_relic_id;
    }

    public Long getStaff_id() {
        return staff_id;
    }

    public void setStaff_id(Long staff_id) {
        this.staff_id = staff_id;
    }

    public Long getEnter_library_value() {
        return enter_library_value;
    }

    public void setEnter_library_value(Long enter_library_value) {
        this.enter_library_value = enter_library_value;
    }

    public Date getEnter_library_time() {
        return enter_library_time;
    }

    public void setEnter_library_time(Date enter_library_time) {
        this.enter_library_time = enter_library_time;
    }

    public Long getOut_library_value() {
        return out_library_value;
    }

    public void setOut_library_value(Long out_library_value) {
        this.out_library_value = out_library_value;
    }

    public Date getOut_library_time() {
        return out_library_time;
    }

    public void setOut_library_time(Date out_library_time) {
        this.out_library_time = out_library_time;
    }
}
