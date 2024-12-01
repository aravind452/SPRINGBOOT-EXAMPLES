package com.springdata.mapping.repo;


import com.springdata.mapping.model.Course;
import com.springdata.mapping.model.CourseMaterial;
import com.springdata.mapping.model.Student;
import com.springdata.mapping.model.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;

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


    @Test
    public void findAllPagination() {
        Pageable firstPageWithThreeRecords = PageRequest.of(0, 3);
        Pageable secondPageWithTwoRecords = PageRequest.of(1, 2);

        List<Course> courses = courseRepository.findAll(firstPageWithThreeRecords).getContent();

        long totalElements = courseRepository.findAll(firstPageWithThreeRecords)
                .getTotalElements();

        long totalPages = courseRepository.findAll(firstPageWithThreeRecords)
                .getTotalPages();

        System.out.println("courses = " + courses);

        System.out.println("Total Elements = " + totalElements);

        System.out.println("Total Pages = " + totalPages);
    }

    @Test
    public void findAllWithSorting() {
        Pageable sortByTitle = PageRequest.of(0,
                2,
                Sort.by("title")
        );

        Pageable sortByCreditDesc = PageRequest.of(
                0,
                2
                , Sort.by("credit")
                        .descending()
        );

        Pageable sortByTitleAndCreditDesc = PageRequest.of(
                0,
                2
                , Sort.by("title").descending()
                        .and(Sort.by("credit"))
        );

        List<Course> courses = courseRepository.findAll(sortByCreditDesc).getContent();
        System.out.println("courses = " + courses);
    }


    @Test
    public void saveCourseWithStudentAndTeacher() {
        Teacher teacher = Teacher.builder()
                .firstName("Varma")
                .lastName("J")
                .build();

        Course course = Course.builder()
                .title("AI")
                .credit(45)
                .teacher(teacher)
                .build();

        Student student = Student.builder()
                .firstName("Aravind")
                .lastName("J")
                .emailId("aravindaru452")
                .build();

        course.addStudent(student);

        courseRepository.save(course);

    }


}