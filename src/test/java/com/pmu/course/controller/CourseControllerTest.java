package com.pmu.course.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.pmu.course.model.Course;
import com.pmu.course.model.Response;
import com.pmu.course.repository.CourseRepository;
import com.pmu.course.service.impl.CourseServiceImpl;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Optional;

import java.util.UUID;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

class CourseControllerTest {
    /**
     * Method under test: {@link CourseController#saveCourse(Course)}
     */
    @Test
    void testSaveCourse() {

        Course course = new Course();
        course.setDate(LocalDate.of(1970, 1, 1));
        course.setId(UUID.randomUUID());
        course.setNom("Nom");
        course.setNumero(10);
        course.setPartants(new HashSet<>());
        CourseRepository courseRepository = mock(CourseRepository.class);
        when(courseRepository.save(Mockito.<Course>any())).thenReturn(course);
        CourseController courseController = new CourseController(new CourseServiceImpl(courseRepository));

        Course course2 = new Course();
        course2.setDate(LocalDate.of(1970, 1, 1));
        course2.setId(UUID.randomUUID());
        course2.setNom("Nom");
        course2.setNumero(10);
        course2.setPartants(new HashSet<>());
        ResponseEntity<Response> actualSaveCourseResult = courseController.saveCourse(course2);
        assertTrue(actualSaveCourseResult.hasBody());
        assertTrue(actualSaveCourseResult.getHeaders().isEmpty());
        assertEquals(200, actualSaveCourseResult.getStatusCodeValue());
        Response body = actualSaveCourseResult.getBody();
        assertEquals("course créée", body.getMessage());
        assertNull(body.getDevelopperMessage());
        assertEquals(1, body.getData().size());
        assertEquals(201, body.getStatusCode());
        assertEquals(HttpStatus.CREATED, body.getStatus());
        assertNull(body.getReason());
        verify(courseRepository).save(Mockito.<Course>any());
    }

    /**
     * Method under test: {@link CourseController#getCourses()}
     */
    @Test
    void testGetCourses() {

        CourseRepository courseRepository = mock(CourseRepository.class);
        when(courseRepository.findAll(Mockito.<Pageable>any())).thenReturn(new PageImpl<>(new ArrayList<>()));
        ResponseEntity<Response> actualCourses = (new CourseController(new CourseServiceImpl(courseRepository)))
                .getCourses();
        assertTrue(actualCourses.hasBody());
        assertTrue(actualCourses.getHeaders().isEmpty());
        assertEquals(200, actualCourses.getStatusCodeValue());
        Response body = actualCourses.getBody();
        assertEquals("liste des courses", body.getMessage());
        assertNull(body.getDevelopperMessage());
        assertEquals(1, body.getData().size());
        assertEquals(200, body.getStatusCode());
        assertEquals(HttpStatus.OK, body.getStatus());
        assertNull(body.getReason());
        verify(courseRepository).findAll(Mockito.<Pageable>any());
    }

    /**
     * Method under test: {@link CourseController#getCourse(UUID)}
     */
    @Test
    void testGetCourse() {

        Course course = new Course();
        course.setDate(LocalDate.of(1970, 1, 1));
        course.setId(UUID.randomUUID());
        course.setNom("Nom");
        course.setNumero(10);
        course.setPartants(new HashSet<>());
        Optional<Course> ofResult = Optional.of(course);
        CourseRepository courseRepository = mock(CourseRepository.class);
        when(courseRepository.findById(Mockito.<UUID>any())).thenReturn(ofResult);
        CourseController courseController = new CourseController(new CourseServiceImpl(courseRepository));
        ResponseEntity<Response> actualCourse = courseController.getCourse(UUID.randomUUID());
        assertTrue(actualCourse.hasBody());
        assertTrue(actualCourse.getHeaders().isEmpty());
        assertEquals(200, actualCourse.getStatusCodeValue());
        Response body = actualCourse.getBody();
        assertEquals("Course trouvé", body.getMessage());
        assertNull(body.getDevelopperMessage());
        assertEquals(1, body.getData().size());
        assertEquals(200, body.getStatusCode());
        assertEquals(HttpStatus.OK, body.getStatus());
        assertNull(body.getReason());
        verify(courseRepository).findById(Mockito.<UUID>any());
    }

    /**
     * Method under test: {@link CourseController#updateCourse(Course)}
     */
    @Test
    void testUpdateCourse() {

        Course course = new Course();
        course.setDate(LocalDate.of(1970, 1, 1));
        course.setId(UUID.randomUUID());
        course.setNom("Nom");
        course.setNumero(10);
        course.setPartants(new HashSet<>());
        CourseRepository courseRepository = mock(CourseRepository.class);
        when(courseRepository.save(Mockito.<Course>any())).thenReturn(course);
        CourseController courseController = new CourseController(new CourseServiceImpl(courseRepository));

        Course course2 = new Course();
        course2.setDate(LocalDate.of(1970, 1, 1));
        course2.setId(UUID.randomUUID());
        course2.setNom("Nom");
        course2.setNumero(10);
        course2.setPartants(new HashSet<>());
        ResponseEntity<Response> actualUpdateCourseResult = courseController.updateCourse(course2);
        assertTrue(actualUpdateCourseResult.hasBody());
        assertTrue(actualUpdateCourseResult.getHeaders().isEmpty());
        assertEquals(200, actualUpdateCourseResult.getStatusCodeValue());
        Response body = actualUpdateCourseResult.getBody();
        assertEquals("Course créée", body.getMessage());
        assertNull(body.getDevelopperMessage());
        assertEquals(1, body.getData().size());
        assertEquals(202, body.getStatusCode());
        assertEquals(HttpStatus.ACCEPTED, body.getStatus());
        assertNull(body.getReason());
        verify(courseRepository).save(Mockito.<Course>any());
    }

    /**
     * Method under test: {@link CourseController#deleteCourse(UUID)}
     */
    @Test
    void testDeleteCourse() {

        CourseRepository courseRepository = mock(CourseRepository.class);
        doNothing().when(courseRepository).deleteById(Mockito.<UUID>any());
        CourseController courseController = new CourseController(new CourseServiceImpl(courseRepository));
        ResponseEntity<Response> actualDeleteCourseResult = courseController.deleteCourse(UUID.randomUUID());
        assertTrue(actualDeleteCourseResult.hasBody());
        assertTrue(actualDeleteCourseResult.getHeaders().isEmpty());
        assertEquals(200, actualDeleteCourseResult.getStatusCodeValue());
        Response body = actualDeleteCourseResult.getBody();
        assertEquals("Suppresion course effectuée", body.getMessage());
        assertNull(body.getDevelopperMessage());
        assertEquals(1, body.getData().size());
        assertEquals(200, body.getStatusCode());
        assertEquals(HttpStatus.OK, body.getStatus());
        assertNull(body.getReason());
        verify(courseRepository).deleteById(Mockito.<UUID>any());
    }

}

