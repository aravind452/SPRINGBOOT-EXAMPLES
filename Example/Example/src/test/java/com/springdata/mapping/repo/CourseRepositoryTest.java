package com.springdata.mapping.repo;


import com.springdata.mapping.model.Course;
import com.springdata.mapping.model.CourseMaterial;
import com.springdata.mapping.model.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class CourseRepositoryTest {


    @Autowired
    private CourseRepository courseRepository;

    @Test
    public void saveCourse() {
        CourseMaterial courseMaterial = CourseMaterial.builder()
                .url("www.devops.com")
                .build();

        Course course = Course.builder()
                .title("devops")
                .credit(53)
                .courseMaterial(courseMaterial)
                .build();

        courseRepository.save(course);

    }


    @Test
    public void saveCourseWithTeacher() {
        CourseMaterial courseMaterial = CourseMaterial.builder()
                .url("www.python.com")
                .build();

        Teacher teacher = Teacher.builder()
                .firstName("Priyanka")
                .lastName("Singh")
                .build();
        Course course = Course.builder()
                .title("python")
                .credit(666)
                .teacher(teacher)
                .courseMaterial(courseMaterial)
                .build();

        courseRepository.save(course);
    }

}