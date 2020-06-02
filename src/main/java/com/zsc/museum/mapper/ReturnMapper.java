package com.zsc.museum.mapper;

import com.zsc.museum.domain.Return;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface ReturnMapper {
    @Select("SELECT * FROM returnForm")
    List<Return> findAll();

    @Delete("DELETE FROM returnForm WHERE returnId=#{returnId}")
    int returnDelete(Long culturalRelicId);

    @Insert("INSERT INTO returnForm(culturalRelicId,forWho,returnTime,borrowTime)"+
            "values (#{culturalRelicId},#{forWho},#{returnTime},#{borrowTime})")
    int Insert(Return return1);
}
