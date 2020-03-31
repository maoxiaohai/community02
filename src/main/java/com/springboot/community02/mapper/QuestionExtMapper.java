package com.springboot.community02.mapper;

import com.springboot.community02.model.Question;
import com.springboot.community02.model.QuestionExample;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

import java.util.List;

public interface QuestionExtMapper {
    int incView(Question question);
}