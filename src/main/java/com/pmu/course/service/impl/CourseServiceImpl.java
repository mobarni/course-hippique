package com.pmu.course.service.impl;

import com.pmu.course.model.Course;
import com.pmu.course.repository.CourseRepository;
import com.pmu.course.service.CourseService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Slf4j
public class CourseServiceImpl implements CourseService {

    private final CourseRepository courseRepository;

    @Override
    public Course create(Course course) {
        log.info("Enregistrement de la course: {}",course.getId());
        return courseRepository.save(course);
    }

    @Override
    public List<Course> list(int limit) {
        log.info("Liste des courses existantes");
        return courseRepository.findAll(PageRequest.of(0,limit)).toList();
    }

    @Override
    public Course update(Course course) {
        log.info("modification de la course: {}",course.getId());
        return courseRepository.save(course);
    }

    @Override
    public boolean delete(UUID id) {
        log.info("suppression de la course: {}",id);
        courseRepository.deleteById(id);
        return true;
    }

    @Override
    public Course get(UUID id) {
        log.info("recherche de la course: {}",id);
        return courseRepository.findById(id).get();
    }
}
