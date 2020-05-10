package com.zyl.common.Ahome.mapper;

import com.zyl.common.Ahome.pojo.User;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface UserMapper {
    @Select("select * from user")
    List<User> getAll();

    @Insert("insert into user (id,name) value (#{id} ,#{name})")
    void addUser(User user);

    @Delete("delete from user where id = #{id}")
    void deleteUser(@Param("id") String id);
}
