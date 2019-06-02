package com.idea.devdocs.services;


import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@Service
public class Topics {
    private Logger logger = LoggerFactory.getLogger(Docs.class);
    public Map<String, Object> topicsMapper(int id) throws IOException, ParseException {
        JSONParser jsonParser = new JSONParser();

        List<Map<String, Object>> result = new LinkedList<>();
        Map<String, Object> res = new HashMap<>();
        Map<String, Object> map;

        try(FileReader reader = new FileReader("C:\\Users\\shivaranjan.k\\Desktop\\devdocs\\src\\main\\resources\\static\\jsonFiles\\topics.json")) {
            Object obj = jsonParser.parse(reader);
            JSONArray topicList = (JSONArray) obj;

            for(Object m: topicList) {
                map = (Map<String, Object>) m;
                    Long fetchedId = (Long) map.get("DocTagId");
                if(fetchedId.intValue() == id) {
                    result.add(map);
                }
            }
        } catch(IOException e) {
            System.out.println(e);
        }

        if(!result.isEmpty()) {
            res.put("response", result);
            return res;
        }

        return null;
    }
}
