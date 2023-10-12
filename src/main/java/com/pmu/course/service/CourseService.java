package com.pmu.course.service;

import com.pmu.course.model.Course;

import java.util.List;
import java.util.UUID;

public interface CourseService {
    Course create(Course course);
    List<Course> list(int limit);
    Course get(UUID id);
    Course update(Course course);
    boolean delete(UUID id);
}
