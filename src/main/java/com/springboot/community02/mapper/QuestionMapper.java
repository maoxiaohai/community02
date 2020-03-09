package com.springboot.community02.mapper;

import com.springboot.community02.model.Question;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface QuestionMapper {
    @Insert("insert into question(title,description,gmt_create,gmt_modified,creator,tag,avatar_url) values(#{title},#{description},#{gmtCreate},#{gmtModified},#{creator},#{tag},#{avatarUrl})")
    public void insert(Question question);
}
