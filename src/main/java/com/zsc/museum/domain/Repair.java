package com.zsc.museum.domain;

import java.util.Date;

/*
送修实体类  用于存储文物的送修信息
*/

public class Repair {
    Long cultural_relic_id; //文物编号
    Date repair_time;       //送修时间
    String repair_with;     //送修方

    public Long getCultural_relic_id() {
        return cultural_relic_id;
    }

    public void setCultural_relic_id(Long cultural_relic_id) {
        this.cultural_relic_id = cultural_relic_id;
    }

    public Date getRepair_time() {
        return repair_time;
    }

    public void setRepair_time(Date repair_time) {
        this.repair_time = repair_time;
    }

    public String getRepair_with() {
        return repair_with;
    }

    public void setRepair_with(String repair_with) {
        this.repair_with = repair_with;
    }
}
