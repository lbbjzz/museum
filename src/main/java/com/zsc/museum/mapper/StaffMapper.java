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

    @Insert("INSERT INTO staff(name,officer,number,password)"+
            "values (#{name},#{officer},#{number},#{password})")
    int Insert(Staff staff);

    @Update("UPDATE staff SET name=#{name},officer=#{officer},number=#{number},password=#{password} " +
            "WHERE id=#{id}")
    int update(Staff staff);



    //查询登录
    @Select("select name from staff where number=#{number} and password=#{password}")
    public String login(@Param("number") String number, @Param("password") String password);

    @Select("UPDATE status SET path=#{path} where id=#{id}")
    public String status(@Param("path") int path, @Param("id") int id);


    @Select("select id from status where path=#{path}")
    public String selectstatus(@Param("path") int path);
}
