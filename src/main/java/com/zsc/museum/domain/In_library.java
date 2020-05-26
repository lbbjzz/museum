package com.zsc.museum.domain;

import java.util.Date;
/*
入馆登记实体类  用于存储文物的入馆登记信息
*/
public class In_library {
    Long id;//仓库编号
    String is_leave;//是否离馆
    String is_borrow;//是否外借
    String is_exhibition;//是否展览
    String is_repairv;//是否送修
    Date storage_time; //收储时间
    Long storage_warehouse;//收储仓库
    String storage_rack;//收储货架
    Date leave_time;//离馆时间
    Long init_value;//入馆价值

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIs_leave() {
        return is_leave;
    }

    public void setIs_leave(String is_leave) {
        this.is_leave = is_leave;
    }

    public String getIs_borrow() {
        return is_borrow;
    }

    public void setIs_borrow(String is_borrow) {
        this.is_borrow = is_borrow;
    }

    public String getIs_exhibition() {
        return is_exhibition;
    }

    public void setIs_exhibition(String is_exhibition) {
        this.is_exhibition = is_exhibition;
    }

    public String getIs_repairv() {
        return is_repairv;
    }

    public void setIs_repairv(String is_repairv) {
        this.is_repairv = is_repairv;
    }

    public Date getStorage_time() {
        return storage_time;
    }

    public void setStorage_time(Date storage_time) {
        this.storage_time = storage_time;
    }

    public Long getStorage_warehouse() {
        return storage_warehouse;
    }

    public void setStorage_warehouse(Long storage_warehouse) {
        this.storage_warehouse = storage_warehouse;
    }

    public String getStorage_rack() {
        return storage_rack;
    }

    public void setStorage_rack(String storage_rack) {
        this.storage_rack = storage_rack;
    }

    public Date getLeave_time() {
        return leave_time;
    }

    public void setLeave_time(Date leave_time) {
        this.leave_time = leave_time;
    }

    public Long getInit_value() {
        return init_value;
    }

    public void setInit_value(Long init_value) {
        this.init_value = init_value;
    }
}
