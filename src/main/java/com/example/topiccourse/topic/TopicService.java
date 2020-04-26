package com.example.topiccourse.topic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class TopicService {

    @Autowired
    private TopicRepository repository;

    public List<Topic> getTopics() {
        return (List<Topic>) repository.findAll();
    }

    public void addTopic( Topic topic) {
        repository.save(topic);
    }

    public void updateTopic(Topic topic, int id) {
        topic.setId(id);
        repository.save(topic);
    }

    public void deleteTopic(int id) {
        Topic topic = repository.findById(id).get();
        repository.delete(topic);
    }
}
