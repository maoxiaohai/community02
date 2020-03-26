package com.springboot.community02.mapper;

import com.springboot.community02.model.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface UserMapper {
    @Insert("INSERT INTO user (name,account_id,token,gmt_create,gmt_modified,avatar_url) values(#{name},#{accountId},#{token},#{gmtCreate},#{gmtModified},#{avatarUrl})")
    public void insert(User user);

    @Select("SELECT * FROM  user where token=#{token}")
    public User findByToken( String token);
    @Select("SELECT * FROM  user where id=#{id}")
    public User findById(Integer id);

    @Select("SELECT * FROM  user where account_id=#{accountId}")
    List<User> getByAccountId(String accountId);

    @Update("update user set name=#{name},token=#{token},gmt_modified=#{gmtModified},avatar_url=#{avatarUrl} where id=#{id}")
    void update(User user);
}
