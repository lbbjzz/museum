package com.zsc.museum.mapper;

import com.zsc.museum.domain.Borrow;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface BorrowMapper {

    @Select("SELECT * FROM borrow")
    List<Borrow> findAll();

    @Insert("INSERT INTO borrow(culturalRelicId,toWho,borrowTime)"+
            "values (#{culturalRelicId},#{toWho},#{borrowTime})")
    int Insert(Borrow borrow);

    @Delete("DELETE FROM borrow WHERE culturalRelicId=#{culturalRelicId}")
    int borrowDelete(Long culturalRelicId);

    @Select("SELECT * FROM borrow WHERE culturalRelicId=#{culturalRelicId}")
    Borrow selectOne(Long id);
}
