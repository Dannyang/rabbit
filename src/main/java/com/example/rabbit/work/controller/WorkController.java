package com.example.rabbit.work.controller;

import com.example.rabbit.work.entity.CommonPageVo;
import com.example.rabbit.work.entity.PushMessageVO;
import com.example.rabbit.work.entity.ResponseVo;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WorkController {
    public ResponseVo<CommonPageVo<PushMessageVO>> queryPageMessage;
}
