package com.pmu.course.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import org.junit.jupiter.api.Test;

class CourseTest {

    @Test
    void testConstructor() {
        Course actualCourse = new Course();
        LocalDate date = LocalDate.of(1970, 1, 1);
        actualCourse.setDate(date);
        UUID id = UUID.randomUUID();
        actualCourse.setId(id);
        actualCourse.setNom("Nom");
        actualCourse.setNumero(10);
        HashSet<Partant> partants = new HashSet<>();
        actualCourse.setPartants(partants);
        LocalDate actualDate = actualCourse.getDate();
        UUID actualId = actualCourse.getId();
        String actualNom = actualCourse.getNom();
        Integer actualNumero = actualCourse.getNumero();
        Set<Partant> actualPartants = actualCourse.getPartants();
        assertSame(date, actualDate);
        assertSame(id, actualId);
        assertEquals("Nom", actualNom);
        assertEquals(10, actualNumero.intValue());
        assertSame(partants, actualPartants);
    }

    /**
     * Method under test: {@link Course#equals(Object)}
     */
    @Test
    void testEquals() {
        Course course = new Course();
        course.setDate(LocalDate.of(1970, 1, 1));
        course.setId(UUID.randomUUID());
        course.setNom("Nom");
        course.setNumero(10);
        course.setPartants(new HashSet<>());

        Course course2 = new Course();
        course2.setDate(LocalDate.of(1970, 1, 1));
        course2.setId(UUID.randomUUID());
        course2.setNom("Nom2");
        course2.setNumero(11);
        course2.setPartants(new HashSet<>());
        assertNotEquals(course, course2);
    }

    /**
     * Method under test: {@link Course#equals(Object)}
     */
    @Test
    void testEqualsWithPartants() {
        Partant partant = new Partant();
        partant.setId(UUID.randomUUID());
        partant.setNom("Partant");
        partant.setNumero(1);

        HashSet<Partant> partants = new HashSet<>();
        partants.add(partant);

        Course course = new Course();
        course.setDate(LocalDate.of(1970, 1, 1));
        course.setId(null);
        course.setNom("Nom");
        course.setNumero(10);
        course.setPartants(partants);

        Course course2 = new Course();
        course2.setDate(LocalDate.of(1970, 1, 1));
        course2.setId(null);
        course2.setNom("Nom");
        course2.setNumero(10);
        course2.setPartants(new HashSet<>());
        assertNotEquals(course, course2);
    }
}

