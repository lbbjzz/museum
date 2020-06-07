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

    @Delete("DELETE FROM warehouse WHERE id=#{id}")
    int delete(Long id);

    @Select("SELECT * FROM warehouse WHERE id=#{id}")
    Warehouse SelectOne(Long id);

    @Select("SELECT * FROM warehouse WHERE warehouseName LIKE CONCAT('%',#{warehouseName},'%')")
    List<Warehouse> SelectByName(String warehouse_name);

    @Insert("INSERT INTO warehouse(id,warehouseName,shelvesNumber)"+
            "values (#{id},#{warehouseName},#{shelvesNumber})")
    int Insert(Warehouse warehouse);

    @Update("UPDATE warehouse SET warehouseName=#{warehouseName},shelvesNumber=#{shelvesNumber} WHERE id=#{id}")
    int update(Warehouse warehouse);
}
