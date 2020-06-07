package com.zsc.museum.mapper;
//文物实体类操作接口

import com.zsc.museum.domain.Cultural_relic;
import com.zsc.museum.domain.Warehouse;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface CulturalMapper {


    @Select("SELECT * FROM warehouse")
    List<Warehouse> findAllWareHouse();

    @Select("SELECT * FROM cultural_relic")
    List<Cultural_relic> findAll();

    @Select("SELECT * FROM cultural_relic LIMIT #{i},5")
    List<Cultural_relic> FindtoPage(Integer i);

    @Delete("DELETE FROM cultural_relic WHERE id=#{id}")
    int delete(Long id);

    @Select("SELECT * FROM cultural_relic WHERE id=#{id}")
    Cultural_relic SelectOne(Long id);

    @Select("SELECT * FROM cultural_relic WHERE name LIKE CONCAT('%',#{name},'%')")
    List<Cultural_relic> SelectByName(String name);

    @Insert("INSERT INTO cultural_relic(name,number,wareHouse,material,age,source,size,image)"+
    "values (#{cultural_relic.name},#{cultural_relic.number},#{cultural_relic.wareHouse},#{cultural_relic.material},#{cultural_relic.age},#{cultural_relic.source},#{cultural_relic.size},#{image})")
    int Insert(@Param("image") String image,@Param("cultural_relic") Cultural_relic cultural_relic);

    @Update("UPDATE cultural_relic SET name=#{cultural_relic.name}, number=#{cultural_relic.number},material=#{cultural_relic.material}," +
            "age=#{cultural_relic.age},wareHouse=#{cultural_relic.wareHouse},source=#{cultural_relic.source},size=#{cultural_relic.size}, " +
            "image=#{image} " +
            "WHERE id=#{cultural_relic.id}")
    int update(@Param("image") String image,@Param("cultural_relic") Cultural_relic cultural_relic);

    //文物估值
    @Select("UPDATE cultural_relic SET price=#{price} WHERE id=#{id}")
    public String value(@Param("price") String price, @Param("id") String id);

    //添加照片路径
    @Select("UPDATE cultural_relic SET image=#{imgFileName} WHERE id=#{id}")
    public String imgFileName(@Param("imgFileName") String imgFileName, @Param("id") String id);

//    //查询文物编号
//    @Select("select name from cultural_relic where id=#{imgId}")
//    public String select(@Param("imgId") String imgId);

}
