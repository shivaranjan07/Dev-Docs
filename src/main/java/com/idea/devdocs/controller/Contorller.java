package com.idea.devdocs.controller;


import com.idea.devdocs.services.Docs;
import com.idea.devdocs.services.Examples;
import com.idea.devdocs.services.Topics;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.Map;

@RestController
@CrossOrigin(maxAge = 3600)
@RequestMapping("/stack-overflow")
public class Contorller {

    private final Docs docs;

    private final Topics topics;

    private final Examples examples;

    @Autowired
    public Contorller(Docs docs, Topics topics, Examples examples) {
        this.docs = docs;
        this.topics = topics;
        this.examples = examples;
    }

    @GetMapping(value = "/docs", produces = "application/json")
    public Map<String, Object> docsResponse() throws IOException, ParseException {
        return docs.docsMapper();
    }

    @GetMapping("/topics/{docId}")
    public Map<String, Object> topicsResponse(@PathVariable("docId") int id) throws IOException, ParseException {
        return topics.topicsMapper(id);
    }

    @GetMapping("/examples/{topicId}")
    public Map<String, Object> exampleResponse(@PathVariable("topicId") int id) throws IOException, ParseException {
        return examples.examplesMapper(id);
    }
}
