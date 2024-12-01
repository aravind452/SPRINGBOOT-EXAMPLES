package com.springdata.mapping.repo;

import com.springdata.mapping.model.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
class TeacherRepositoryTest {

    @Autowired
    private TeacherRepository teacherRepository;


    @Test
    public void saveTeacher() {
//        Course course1 = Course.builder()
//                .title("English")
//                .credit(56)
//                .build();
//        Course course2 = Course.builder()
//                .title("Java")
//                .credit(6)
//                .build();
        Teacher teacher = Teacher.builder()
                .firstName("gupta")
                .lastName("j")
                //.courses(List.of(course1, course2))
                .build();


        teacherRepository.save(teacher);
    }


    @Test
    public void saveTeacher1() {
        Teacher teacher = Teacher.builder()
                .firstName("sharma")
                .lastName("j")
                .build();


        teacherRepository.save(teacher);

    }

}