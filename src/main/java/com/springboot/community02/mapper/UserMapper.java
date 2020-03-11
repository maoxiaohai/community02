package com.springboot.community02.mapper;

import com.springboot.community02.model.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper {
    @Insert("INSERT INTO user (name,account_id,token,gmt_create,gmt_modified,avatar_url) values(#{name},#{accountId},#{token},#{gmtCreate},#{gmtModified},#{avatarUrl})")
    public void insert(User user);

    @Select("SELECT * FROM  user where token=#{token}")
    public User findByToken(@Param("token") String token);
    @Select("SELECT * FROM  user where id=#{id}")
    public User findById(@Param("id") Integer id);
}
