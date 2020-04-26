package com.example.topiccourse.course;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class CourseService {
    @Autowired
    private CourseRepository repository;

    public List<Course> getCourses(int topicId) {
        return (List<Course>) repository.findCoursesByTopicId(topicId);
    }

    public Course getCourse(int id) {
        return repository.findById(id).get();
    }

    public void addCourse(Course course) {
        repository.save(course);
    }

    public void updateCourse(Course course, int id) {
        course.setId(id);
        repository.save(course);
    }

    public void deleteCourse(int id) {
        repository.deleteById(id);
    }
}
