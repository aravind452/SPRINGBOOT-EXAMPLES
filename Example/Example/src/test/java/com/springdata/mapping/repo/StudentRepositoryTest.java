package com.springdata.mapping.repo;

import com.springdata.mapping.model.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;


@SpringBootTest

public class StudentRepositoryTest {

    @Autowired
    private StudentRepository studentRepository;

    @Test
    public void saveStudent() {

        Student student = Student.builder()
                .emailId("aravindj2002@outlook.com")
                .firstName("aravind")
                .lastName("j")
                .guardianName("rahul")
                .guardianEmail("rahul@gmail")
                .guardianMobile("8999999953")
                .build();
        studentRepository.save(student);


    }


    @Test
    public void printAllStudents() {

        List<Student> list = studentRepository.findAll();
        System.out.println(list);

    }

}