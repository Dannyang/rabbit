package com.example.rabbit.entity;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * 数据特殊性前端穿值id-name,数仓接收name
 */
public class CustomIdNameSerializer extends JsonDeserializer<List<String>> {

    @Override
    public List<String> deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
        List<String> parsedList = new ArrayList<>();
        ObjectCodec oc = p.getCodec();
        JsonNode treeNode = oc.readTree(p);
        if (treeNode.isArray()) {
            for (final JsonNode objNode : treeNode) {
                String name = objNode.textValue().split("-")[1];
                parsedList.add(name);
            }
        }
        return parsedList;
    }
}
