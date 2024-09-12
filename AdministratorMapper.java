package cn.edu.dlu.secondclass.Dao;

import cn.edu.dlu.secondclass.entity.Administrator;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface AdministratorMapper {

    @Insert("INSERT INTO administrators (id, p_id, username, password, phone, email, is_delete) VALUES (#{id}, #{pId}, #{username}, #{password}, #{phone}, #{email}, #{isDelete})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int register(Administrator admin);

    @Select("SELECT * FROM administrators WHERE username = #{username} AND password = #{password}")
    Administrator login(String username, String password);
}