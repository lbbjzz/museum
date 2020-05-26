package com.zsc.museum.mapper;
import com.zsc.museum.domain.Staff;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;



//用户实体类操作接口
import java.util.List;
@Mapper
public interface StaffMapper {
    @Select("SELECT * FROM staff")
    List<Staff> findAll();
    @Select("SELECT * FROM staff LIMIT #{i},5")
    List<Staff> FindtoPage(Integer i);

    @Delete("DELETE FROM staff WHERE id=#{id}")
    int delete(Long id);

    @Select("SELECT * FROM staff WHERE id=#{id}")
    Staff SelectOne(Long id);

    @Select("SELECT * FROM staff WHERE name LIKE CONCAT('%',#{name},'%')")
    List<Staff> SelectByName(String name);

    @Insert("INSERT INTO staff(id,name,officer)"+
            "values (#{id},#{name},#{officer},)")
    int Insert(Staff staff);

    @Update("UPDATE staff SET id=#{id}, name=#{name},officer=#{officer}," +
            "WHERE id=#{id}")
    int update(Staff staff);



    //查询登录
    @Select("select name from staff where number=#{number} and password=#{password}")
    public String login(@Param("number") String number, @Param("password") String password);


}
