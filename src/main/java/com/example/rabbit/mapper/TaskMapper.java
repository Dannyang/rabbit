package com.example.rabbit.mapper;

import com.example.rabbit.entity.Condition;
import com.example.rabbit.entity.TaskCountDescDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface TaskMapper {
    List<TaskCountDescDTO> get(@Param("condition") Condition condition);
}
