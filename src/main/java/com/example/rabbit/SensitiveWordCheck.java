package com.example.rabbit;

import org.ahocorasick.trie.Emit;
import org.ahocorasick.trie.Token;
import org.ahocorasick.trie.Trie;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class SensitiveWordCheck {
    public static void main(String[] args) {
        System.out.println(Integer.MIN_VALUE);
        List<String> strings = Arrays.asList("加班", "再加班");
        Collection<Emit> emits = t4(strings);
        for (Emit emit:emits){
            System.out.println(emit.getEnd());
            System.out.println(emit.getStart());
            System.out.println(emit.getKeyword());
        }
    }
    //  premain方法：JVM会首先调用这个方法。通过这个方法我们就可以把属性instru初始化化成功，通过Instrumentation的getObjectSize(Object object)方法我们就获取一个对象的大小了
//    public static void premain(String agentArgs, Instrumentation inst){
//
//    }

    public static Collection<Emit> t4(List<String> keyWords){
        Trie.TrieBuilder builder = Trie.builder();
        for (String w : keyWords){
            builder.addKeyword(w);
        }
        Trie trie = builder.build();
        return trie.parseText("我是真的不想再加班了");
    }
    public static Collection<Emit> t0(){
        Trie trie = Trie.builder()
                .addKeyword("hers")
                .addKeyword("his")
                .addKeyword("she")
                .addKeyword("he")
                .build();
        long l = System.currentTimeMillis();
        Collection<Emit> emits = trie.parseText("ushers");
        System.out.println(System.currentTimeMillis()-l);
        return emits;
    }
    public static Collection<Emit> t1(){
        Trie trie = Trie.builder()
                .onlyWholeWords()
                .addKeyword("加班")
                .build();
        return trie.parseText("我不想加班");
    }



    public static void t2(){
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
        System.out.println(html);
    }
}
