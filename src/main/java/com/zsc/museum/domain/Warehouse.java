package com.zsc.museum.domain;

/*
仓库实体类  用于存储文物的存放的仓库信息
*/

public class Warehouse {
    Long id;                //仓库编号
    String warehouse_name;  //仓库名称
    Long shelves_number;    //货架数量

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getWarehouse_name() {
        return warehouse_name;
    }

    public void setWarehouse_name(String warehouse_name) {
        this.warehouse_name = warehouse_name;
    }

    public Long getShelves_number() {
        return shelves_number;
    }

    public void setShelves_number(Long shelves_number) {
        this.shelves_number = shelves_number;
    }
}
