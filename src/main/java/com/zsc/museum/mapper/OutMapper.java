package com.zsc.museum.mapper;

import com.zsc.museum.domain.In_library;
import com.zsc.museum.domain.Out_library;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface OutMapper {

    @Select("SELECT * FROM out_library")
    List<Out_library> findAll();
    @Select("SELECT * FROM out_library LIMIT #{i},5")
    List<Out_library> FindtoPage(Integer i);

    @Delete("DELETE FROM out_library WHERE cultural_relic_id=#{cultural_relic_id}")
    int delete(Long id);

    @Select("SELECT * FROM out_library WHERE cultural_relic_id=#{cultural_relic_id}")
    Out_library SelectOne(Long id);



    @Insert("INSERT INTO out_library(cultural_relic_id,to_where)"+
            "values (#{cultural_relic_id},#{to_where})")
    int Insert(Out_library out_library);

    @Update("UPDATE out_library SET cultural_relic_id=#{cultural_relic_id}, to_where=#{to_where}" +
            "WHERE cultural_relic_id=#{cultural_relic_id}")
    int update(Out_library out_library);


}
