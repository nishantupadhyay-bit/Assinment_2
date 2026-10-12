
package com.assignment2.assignment2.validation;

import com.assignment2.assignment2.model.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class StudentValidatorTest {

    private StudentValidator studentValidator;

    @BeforeEach
    void setUp() {
        studentValidator = new StudentValidator();
    }

    private User createValidStudent() {
        return new User(
                "Nishant",
                22,
                "Delhi",
                101,
                Arrays.asList("A", "B", "D", "E")
        );
    }

    @Test
    void shouldAcceptValidStudent() {
        assertDoesNotThrow(() ->
                studentValidator.validate(createValidStudent()));
    }

    @Test
    void shouldRejectNullStudent() {
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> studentValidator.validate(null)
        );

        assertEquals("Student details cannot be null", exception.getMessage());
    }

    @Test
    void shouldRejectNullName() {
        User user = createValidStudent();
        user.setName(null);

        assertThrows(
                IllegalArgumentException.class,
                () -> studentValidator.validate(user)
        );
    }

    @Test
    void shouldRejectEmptyName() {
        User user = createValidStudent();
        user.setName(" ");

        assertThrows(
                IllegalArgumentException.class,
                () -> studentValidator.validate(user)
        );
    }

    @Test
    void shouldRejectInvalidAge() {
        User user = createValidStudent();
        user.setAge(0);

        assertThrows(
                IllegalArgumentException.class,
                () -> studentValidator.validate(user)
        );
    }

    @Test
    void shouldRejectNegativeAge() {
        User user = createValidStudent();
        user.setAge(-1);

        assertThrows(
                IllegalArgumentException.class,
                () -> studentValidator.validate(user)
        );
    }

    @Test
    void shouldRejectNullAddress() {
        User user = createValidStudent();
        user.setAddress(null);

        assertThrows(
                IllegalArgumentException.class,
                () -> studentValidator.validate(user)
        );
    }

    @Test
    void shouldRejectEmptyAddress() {
        User user = createValidStudent();
        user.setAddress(" ");

        assertThrows(
                IllegalArgumentException.class,
                () -> studentValidator.validate(user)
        );
    }

    @Test
    void shouldRejectInvalidRollNumber() {
        User user = createValidStudent();
        user.setRollNumber(0);

        assertThrows(
                IllegalArgumentException.class,
                () -> studentValidator.validate(user)
        );
    }

    @Test
    void shouldRejectNullCourses() {
        User user = createValidStudent();
        user.setCourses(null);

        assertThrows(
                IllegalArgumentException.class,
                () -> studentValidator.validate(user)
        );
    }

    @Test
    void shouldRejectFewerThanFourDifferentCourses() {
        User user = createValidStudent();
        user.setCourses(Arrays.asList("A", "B", "C"));

        assertThrows(
                IllegalArgumentException.class,
                () -> studentValidator.validate(user)
        );
    }

    @Test
    void shouldRejectDuplicateCourses() {
        User user = createValidStudent();
        user.setCourses(Arrays.asList("A", "A", "B", "C"));

        assertThrows(
                IllegalArgumentException.class,
                () -> studentValidator.validate(user)
        );
    }

    @Test
    void shouldRejectMoreThanFourCourses() {
        User user = createValidStudent();
        user.setCourses(Arrays.asList("A", "B", "C", "D", "E"));

        assertThrows(
                IllegalArgumentException.class,
                () -> studentValidator.validate(user)
        );
    }

    @Test
    void shouldRejectNullCourse() {
        User user = createValidStudent();
        user.setCourses(Arrays.asList("A", "B", "C", null));

        assertThrows(
                IllegalArgumentException.class,
                () -> studentValidator.validate(user)
        );
    }
}
