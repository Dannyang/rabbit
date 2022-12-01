package com.example.rabbit.controller;


import com.example.rabbit.consumer.MyProducer;
import com.example.rabbit.entity.Entity;
import com.example.rabbit.entity.NotificationDetail;
import com.example.rabbit.service.InviteService;
import org.ahocorasick.trie.Emit;
import org.ahocorasick.trie.Token;
import org.ahocorasick.trie.Trie;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class MController {
    private final MyProducer myProducer;

    private final Trie trie;
    private final InviteService inviteService;

    public MController(MyProducer myProducer, Trie trie, InviteService inviteService) {
        this.myProducer = myProducer;
        this.trie = trie;
        this.inviteService = inviteService;
    }

//    @RequestMapping(value = "/send", method = RequestMethod.GET)
//    public void send(@RequestParam("msg") String msg, @RequestParam("key")String key){
//        myProducer.send(key, msg);
//    }

    @RequestMapping(value = "/sen2", method = RequestMethod.POST)
    public void send(@RequestBody Entity entity){
        myProducer.send(entity);
    }



    @RequestMapping(value = "/t1", method = RequestMethod.GET)
    public String t1(){
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
    public List<String> t2(String sentence){
        Collection<Emit> emits = trie.parseText(sentence);
        return emits.stream().map(Emit::getKeyword).collect(Collectors.toList());
    }



    @RequestMapping(value = "/t3", method = RequestMethod.GET)
    public void t3(){
        inviteService.test();
    }

    @RequestMapping(value = "/t4", method = RequestMethod.GET)
    public void t4(){
        inviteService.test2();
    }

    @RequestMapping(value = "/t5", method = RequestMethod.GET)
    public List<NotificationDetail> t5(){
       return  inviteService.test3();
    }
}
