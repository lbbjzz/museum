package com.zsc.museum.mapper;
//文物实体类操作接口

import com.zsc.museum.domain.Cultural_relic;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface CulturalMapper {

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

    @Insert("INSERT INTO cultural_relic(id,name,number,title,material,age,source,size)"+
    "values (#{id},#{name},#{number},#{title},#{material},#{age},#{source},#{size})")
    int Insert(Cultural_relic cultural_relic);

    @Update("UPDATE cultural_relic SET name=#{name}, number=#{number},material=#{material}," +
            "age=#{age},title=#{title},source=#{source},size=#{size} " +
            "WHERE id=#{id}")
    int update(Cultural_relic cultural_relic);

}
