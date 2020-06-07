package com.zsc.museum.domain;

/*
仓库实体类  用于存储文物的存放的仓库信息
*/

public class Warehouse {
    Long id;                //仓库编号
    String warehouseName;  //仓库名称
    Long shelvesNumber;    //货架数量

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getWarehouseName() {
        return warehouseName;
    }

    public void setWarehouseName(String warehouseName) {
        this.warehouseName = warehouseName;
    }

    public Long getShelvesNumber() {
        return shelvesNumber;
    }

    public void setShelvesNumber(Long shelvesNumber) {
        this.shelvesNumber = shelvesNumber;
    }
}
