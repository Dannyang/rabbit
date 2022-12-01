package com.example.rabbit.service;

import com.example.rabbit.entity.NotificationDetail;
import com.example.rabbit.mapper.FeatureMapper;
import com.example.rabbit.mapper.InviteMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class InviteService {
    private final InviteMapper inviteMapper;
    private final FeatureMapper featureMapper;

    public InviteService(InviteMapper inviteMapper, FeatureMapper featureMapper) {
        this.inviteMapper = inviteMapper;
        this.featureMapper = featureMapper;
    }

    @Transactional
    public void test() {
        AtomicInteger count = new AtomicInteger();
        inviteMapper.getAllInvites().forEach(invite -> {
            System.out.println(invite.getCity() + ":" + count.getAndIncrement());
        });
    }

    public void test2() {
        featureMapper.saveFeature(new NotificationDetail());
    }

    public List<NotificationDetail> test3() {
        return featureMapper.getAll();
    }
}

