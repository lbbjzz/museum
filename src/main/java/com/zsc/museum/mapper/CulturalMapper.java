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

    @Insert("INSERT INTO cultural_relic(id,name,number,wareHouse,material,age,source,size,image)"+
    "values (#{cultural_relic.id},#{cultural_relic.name},#{cultural_relic.number},#{cultural_relic.wareHouse},#{cultural_relic.material},#{cultural_relic.age},#{cultural_relic.source},#{cultural_relic.size},#{image})")
    int Insert(@Param("image") String image,@Param("cultural_relic") Cultural_relic cultural_relic);

    @Update("UPDATE cultural_relic SET name=#{name}, number=#{number},material=#{material}," +
            "age=#{age},wareHouse=#{wareHouse},source=#{source},size=#{size} " +
            "WHERE id=#{id}")
    int update(Cultural_relic cultural_relic);

    //文物估值
    @Select("UPDATE cultural_relic SET price=#{price} WHERE id=#{id}")
    public String value(@Param("price") String price, @Param("id") String id);

}
