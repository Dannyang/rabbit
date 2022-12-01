package com.example.rabbit.mapper;

import com.example.rabbit.entity.NotificationDetail;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface FeatureMapper {
    void saveFeature(NotificationDetail detail);

    List<NotificationDetail> getAll();
}
