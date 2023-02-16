package com.example.rabbit.controller;


import com.example.rabbit.aspect.PreventDuplicateClick;
import com.example.rabbit.consumer.MyProducer;
import com.example.rabbit.entity.Condition;
import com.example.rabbit.entity.Entity;
import com.example.rabbit.entity.ProductReq;
import com.example.rabbit.entity.ProductRsp;
import com.example.rabbit.entity.TaskCountDescDTO;
import com.example.rabbit.entity.TestEntity;
import com.example.rabbit.mapper.ProductMapper;
import com.example.rabbit.mapper.TaskMapper;
import com.example.rabbit.service.InviteService;
import com.example.rabbit.service.ProductService;
import com.google.common.collect.Lists;
import org.ahocorasick.trie.Emit;
import org.ahocorasick.trie.Token;
import org.ahocorasick.trie.Trie;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
public class MController {
    private final MyProducer myProducer;

    private final Trie trie;
    private final InviteService inviteService;
    private final ProductService productService;

    private TaskMapper taskMapper;

    private final ProductMapper productMapper;

    public MController(MyProducer myProducer, Trie trie, InviteService inviteService, ProductService productService, TaskMapper taskMapper, ProductMapper productMapper) {
        this.myProducer = myProducer;
        this.trie = trie;
        this.inviteService = inviteService;
        this.productService = productService;
        this.taskMapper = taskMapper;
        this.productMapper = productMapper;
    }

//    @RequestMapping(value = "/send", method = RequestMethod.GET)
//    public void send(@RequestParam("msg") String msg, @RequestParam("key")String key){
//        myProducer.send(key, msg);
//    }

    @RequestMapping(value = "/sen2", method = RequestMethod.POST)
    public void send(@RequestBody Entity entity) {
        myProducer.send(entity);
    }


    @RequestMapping(value = "/t1", method = RequestMethod.GET)
    public String t1() {
        String speech = "The Answer to the Great Question... Of Life, " +
                "the Universe and Everything... Is... Forty-two,' said " +
                "Deep Thought, with infinite majesty and calm.";

        Trie trie = Trie.builder().ignoreOverlaps().onlyWholeWords().ignoreCase()
                .addKeyword("great question")
                .addKeyword("forty-two")
                .addKeyword("deep thought")
                .build();

        Collection<Token> tokens = trie.tokenize(speech);
        StringBuilder html = new StringBuilder();
        html.append("<html><body><p>");

        for (Token token : tokens) {
            if (token.isMatch()) {
                html.append("<i>");
            }
            html.append(token.getFragment());
            if (token.isMatch()) {
                html.append("</i>");
            }
        }

        html.append("</p></body></html>");
        return html.toString();
    }

    @RequestMapping(value = "/t2", method = RequestMethod.GET)
    public List<String> t2(String sentence) {
        Collection<Emit> emits = trie.parseText(sentence);
        return emits.stream().map(Emit::getKeyword).collect(Collectors.toList());
    }


    @RequestMapping(value = "/t3", method = RequestMethod.GET)
    public void t3() {
        inviteService.test();
    }

    @RequestMapping(value = "/t4", method = RequestMethod.GET)
    public void t4() {
        inviteService.test2();
    }

    @RequestMapping(value = "/t5", method = RequestMethod.GET)
    public List<JsonTest> t5(@RequestParam("keyword") String keyword,
                             @RequestParam("types") List<Integer> types) {
        return Lists.newArrayList(JsonTest.builder()
                .time(new Date())
                .build());
    }

    @RequestMapping(value = "/t6", method = RequestMethod.POST)
    public List<ProductRsp> t6(@RequestBody @Validated TestEntity testEntity) {
        return productService.productTree();
    }

    @RequestMapping(value = "/t8", method = RequestMethod.POST)
    public void t8(@RequestBody Map<String, Object> body) {
        productService.batchInsert();
    }


    @RequestMapping(value = "/t7", method = RequestMethod.GET)
    public ProductReq t7(String leafUuid) {
        return productService.getRootProduct(leafUuid);
    }


    @RequestMapping(value = "/t9", method = RequestMethod.GET)
    @PreventDuplicateClick(expireSeconds = 2)
    public ProductReq t9(@RequestParam(value = "id") String leafUuid) {
        return productService.getOne(leafUuid);
    }


    @GetMapping(value = "/t10")
    public List<TaskCountDescDTO> get(Condition condition) {
        return taskMapper.get(condition);
    }

    @GetMapping(value = "/t11")
    public List<ProductReq> get() {
        return productMapper.getOneTest(Collections.singletonList(10L));
    }
}
