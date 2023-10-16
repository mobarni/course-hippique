package com.pmu.course.controller;

import com.pmu.course.model.Course;
import com.pmu.course.model.Response;
import com.pmu.course.service.impl.CourseServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Map;
import java.util.UUID;

import static java.time.LocalDateTime.now;
import static org.springframework.http.HttpStatus.*;

@Controller
@RequestMapping("/course")
@RequiredArgsConstructor
public class CourseController {
    private final CourseServiceImpl courseService;

    @PostMapping("/save")
    public ResponseEntity<Response> saveCourse(@RequestBody @Valid Course course){
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("course",courseService.create(course)))
                        .message("course créée")
                        .status(CREATED)
                        .statusCode(CREATED.value())
                        .build()
        );
    }

    @GetMapping("/list")
    public ResponseEntity<Response> getCourses(){
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("courses", courseService.list(2)))
                        .message("liste des courses")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Response> getCourse(@PathVariable("id") UUID id) {
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("course",courseService.get(id)))
                        .message("Course trouvé")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }

    @PostMapping("/update")
    public ResponseEntity<Response> updateCourse(@RequestBody @Valid Course course){
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("course",courseService.update(course)))
                        .message("Course créée")
                        .status(ACCEPTED)
                        .statusCode(ACCEPTED.value())
                        .build()
        );
    }

    @GetMapping("/delete/{id}")
    public ResponseEntity<Response> deleteCourse(@PathVariable("id") UUID id) {
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("course", courseService.delete(id)))
                        .message("Suppresion course effectuée")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }

}
