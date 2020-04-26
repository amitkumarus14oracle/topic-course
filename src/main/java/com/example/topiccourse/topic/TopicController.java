package com.example.topiccourse.topic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
public class TopicController {

    @Autowired
    private TopicService service;

    @RequestMapping("/topics")
    @GetMapping
    public List<Topic> getTopics() {
        return service.getTopics();
    }

    @RequestMapping(method = RequestMethod.POST, value = "/topics")
    public void addTopic(@RequestBody Topic topic) {
        service.addTopic(topic);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/topics/{id}")
    public void updateTopic(@RequestBody Topic topic, @PathVariable int id ) {
        service.updateTopic(topic, id);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "topics/{id}")
    public void deleteTopic(@PathVariable int id) {
        service.deleteTopic(id);
    }

}
