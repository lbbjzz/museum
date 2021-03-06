package com.zsc.museum.domain;

/*
文物实体类  用于存储文物的基本属性信息
*/

public class Cultural_relic {
    Long id;                //文物编号
    String name;            //文物名称
    Long number;            //数量
    String material;        //材质
    String age;             //年代
    String title;           //年号
    String source;          //来源
    String size;            //尺寸
    Long price;            //价值
    String wareHouse;       //所在仓库
    String image;          //图片路径

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getNumber() {
        return number;
    }

    public void setNumber(Long number) {
        this.number = number;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public String getWareHouse() {
        return wareHouse;
    }

    public void setWareHouse(String wareHouse) {
        this.wareHouse = wareHouse;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return "Cultural_relic{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", number=" + number +
                ", material='" + material + '\'' +
                ", age='" + age + '\'' +
                ", title='" + title + '\'' +
                ", source='" + source + '\'' +
                ", size='" + size + '\'' +
                ", price=" + price +
                ", wareHouse='" + wareHouse + '\'' +
                ", image='" + image + '\'' +
                '}';
    }
}