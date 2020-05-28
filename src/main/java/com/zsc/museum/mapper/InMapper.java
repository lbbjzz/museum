package com.zsc.museum.mapper;

import com.zsc.museum.domain.In_library;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface InMapper {
    @Select("SELECT * FROM in_library")
    List<In_library> findAll();
    @Select("SELECT * FROM in_library LIMIT #{i},5")
    List<In_library> FindtoPage(Integer i);

    @Delete("DELETE FROM in_library WHERE id=#{id}")
    int delete(Long id);

    @Select("SELECT * FROM in_library WHERE id=#{id}")
    In_library SelectOne(Long id);



    @Insert("INSERT INTO in_library(id,is_leave,is_borrow,is_exhibition,is_repairv,storage_time,storage_warehouse" +
            ",storage_rack,leave_time,init_value)"+
            "values (#{id},#{is_leave},#{is_borrow},#{is_exhibition},#{is_repairv},#{storage_time},#{storage_warehouse}" +
            ",#{storage_rack},#{leave_time},#{init_value})")
    int Insert(In_library in_library);

    @Update("UPDATE in_library SET id=#{id}, is_leave=#{is_leave},is_borrow=#{is_borrow},is_exhibition=#{is_exhibition}," +
            "is_repairv=#{is_repairv},storage_time=#{storage_time},storage_warehouse=#{storage_warehouse}," +
            "storage_rack=#{storage_rack},leave_time=#{leave_time}," +
            "init_value=#{init_value}" +
            "WHERE id=#{id}")
    int update(In_library in_library);



}
