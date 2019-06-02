package com.idea.devdocs.services;


import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

@Service
public class Docs {

    private Logger logger = LoggerFactory.getLogger(Docs.class);

    public Map<String, Object> docsMapper() throws IOException, ParseException {
        JSONParser jsonParser = new JSONParser();
        Map<String, Object> docs = new TreeMap<>();
        try(FileReader reader = new FileReader("C:\\Users\\shivaranjan.k\\Desktop\\devdocs\\src\\main\\resources\\static\\jsonFiles\\doctags.json")) {
            Object obj = jsonParser.parse(reader);
            JSONArray doc = (JSONArray) obj;
            docs.put("response",doc);
        } catch(IOException e) {
            logger.error(e+"");
        }
        return docs;
    }
}
