package com.springdata.mapping.repo;

import com.springdata.mapping.model.Guardian;
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
                .build();
        studentRepository.save(student);


    }

    @Test
    public void saveStudentWithGuardian() {
        Guardian guardian = Guardian.builder()
                .name("var")
                .email("nikil@gmail.com")
                .mobile("678888888").build();
        Student student = Student.builder()
                .firstName("rahul")
                .lastName("h")
                .emailId("rahul@gmail.com")
                .guardian(guardian).build();

        studentRepository.save(student);
    }


    @Test
    public void printAllStudents() {

        List<Student> list = studentRepository.findAll();
        System.out.println(list);

    }

    @Test
    public void printStudentByFirstName() {
        List<Student> students = studentRepository.findByFirstName("rahul");
        System.out.println("students = " + students);

    }

    @Test
    public void printStudentByFirstNameContaining() {
        List<Student> students = studentRepository.findByFirstNameContaining("h");
        System.out.println("students = " + students);

    }

    @Test
    public void printStudentBasedOnGuardianName() {
        List<Student> students = studentRepository.findByGuardianName("var");
        System.out.println("students = " + students);

    }

    @Test
    public void printStudentByEmail() {
        Student student = studentRepository.getStudentByEmailAddress("rahul@gmail.com");
        System.out.println("student = " + student);

    }

    @Test
    public void printStudentFirstNameByEmail() {
        String student = studentRepository.getStudentFirstNameByEmailAddress("rahul@gmail.com");
        System.out.println("student = " + student);

    }

    @Test
    public void printStudentByEmailNative() {
        Student student = studentRepository.getStudentByEmailAddressNative("rahul@gmail.com");
        System.out.println("student = " + student);

    }


    @Test
    public void printStudentByEmailNativeNamed() {
        Student student = studentRepository.getStudentByEmailAddressNativeNamed("rahul@gmail.com");
        System.out.println("student = " + student);

    }


    @Test
    public void updateStudentByEmailIdTest() {
        studentRepository.updateStudentByEmailId("rahulidlypoo",
                "rahul@gmail.com");


    }


}