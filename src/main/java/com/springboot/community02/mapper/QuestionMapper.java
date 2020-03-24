package com.springboot.community02.mapper;

import com.springboot.community02.model.Question;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import javax.annotation.security.PermitAll;
import java.util.List;

@Mapper
public interface QuestionMapper {
    @Insert("insert into question(title,description,gmt_create,gmt_modified,creator,tag) values(#{title},#{description},#{gmtCreate},#{gmtModified},#{creator},#{tag})")
    public void insert(Question question);

    @Select("select * from question limit #{offset1},#{param2}")
    List<Question> list(Integer offset1, Integer size);

    @Select("select count(1) from QUESTION")
    Integer count();
    @Select("select * from question where id=#{id}")
    Question getById(Integer id);
}
