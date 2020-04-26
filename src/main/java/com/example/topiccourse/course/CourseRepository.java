package com.example.topiccourse.course;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CourseRepository extends CrudRepository<Course, Integer> {
    public List<Course> findCoursesByTopicId(int topicId);
}
