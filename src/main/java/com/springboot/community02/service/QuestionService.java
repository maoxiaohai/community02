package com.springboot.community02.service;

import com.springboot.community02.dto.QuestionDTO;
import com.springboot.community02.mapper.QuestionMapper;
import com.springboot.community02.mapper.UserMapper;
import com.springboot.community02.model.Question;
import com.springboot.community02.model.User;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class QuestionService {
    @Autowired
    private QuestionMapper questionMapper;
    @Autowired
    private UserMapper userMapper;
    public List<QuestionDTO> list(){
        List<Question> questionList=questionMapper.list();
        List<QuestionDTO> questionDTOList=new ArrayList<>();
        for(Question question:questionList){
            User user = userMapper.findById(question.getCreator());
            QuestionDTO questionDTO=new QuestionDTO();
            BeanUtils.copyProperties(question,questionDTO);
            questionDTO.setUser(user);
            questionDTOList.add(questionDTO);
        }
        return questionDTOList;
    }
}
