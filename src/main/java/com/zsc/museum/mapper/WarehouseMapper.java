package com.zsc.museum.mapper;
import com.zsc.museum.domain.Warehouse;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import java.util.List;


//仓库类操作接口
@Mapper
public interface WarehouseMapper {
    @Select("SELECT * FROM warehouse")
    List<Warehouse> findAll();
    @Select("SELECT * FROM warehouse LIMIT #{i},5")
    List<Warehouse> FindtoPage(Integer i);

    @Delete("DELETE FROM warehouse WHERE id=#{id}")
    int delete(Long id);

    @Select("SELECT * FROM warehouse WHERE id=#{id}")
    Warehouse SelectOne(Long id);

    @Select("SELECT * FROM warehouse WHERE warehouse_name LIKE CONCAT('%',#{warehouse_name},'%')")
    List<Warehouse> SelectByName(String warehouse_name);

    @Insert("INSERT INTO warehouse(id,warehouse_name,shelves_number)"+
            "values (#{id},#{warehouse_name},#{shelves_number},)")
    int Insert(Warehouse warehouse);

    @Update("UPDATE warehouse SET id=#{id}, warehouse_name=#{warehouse_name},shelves_number=#{shelves_number}," +
            "WHERE id=#{id}")
    int update(Warehouse warehouse);



}
