package com.example.topiccourse.course;

import com.example.topiccourse.topic.Topic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CourseController {

    @Autowired
    private CourseService service;

    @RequestMapping("topics/{topicId}/courses")
    public List<Course> getCourses(@PathVariable int topicId) {
        return service.getCourses(topicId);
    }

    @RequestMapping("/courses/{topicId}/courses/{id}")
    public Course getCourse(@PathVariable int id) {
        return service.getCourse(id);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/topics/{topicId}/courses")
    public void addCourse(@RequestBody Course course, @PathVariable int topicId) {
        course.setTopic(new Topic(topicId, "", ""));
        service.addCourse(course);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/topics/{topicId}/courses/{id}")
    public void updateCourse(@RequestBody Course course, @PathVariable int topicId, @PathVariable int id) {
        course.setTopic(new Topic(topicId, "", ""));
        service.updateCourse(course, id);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/topics/{topicId}/courses/{id}")
    public void deleteCourse(@PathVariable int id) {
        service.deleteCourse(id);
    }
}
