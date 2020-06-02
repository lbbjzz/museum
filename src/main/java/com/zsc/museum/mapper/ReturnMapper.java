package com.zsc.museum.mapper;

import com.zsc.museum.domain.Return;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface ReturnMapper {
    @Select("SELECT * FROM return")
    List<Return> findAll();

    @Delete("DELETE FROM return WHERE culturalRelicId=#{culturalRelicId}")
    int returnDelete(Long culturalRelicId);

    @Insert("INSERT INTO return(culturalRelicId,forWho,returnTime)"+
            "values (#{culturalRelicId},#{forWho},#{returnTime})")
    int Insert(Return return1);
}
