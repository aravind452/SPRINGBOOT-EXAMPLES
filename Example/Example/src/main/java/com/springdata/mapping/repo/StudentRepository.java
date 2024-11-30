package com.springdata.mapping.repo;


import com.springdata.mapping.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    public List<Student> findByFirstName(String firstName);

    public List<Student> findByFirstNameContaining(String name);


    public List<Student> findByLastNameNotNull();


    public List<Student> findByGuardianName(String guardianName);


    @Query("select s from Student s where s.emailId = ?1")
    public Student getStudentByEmailAddress(String emailId);

    @Query("select s.firstName from Student s where s.emailId = ?1")
    public String getStudentFirstNameByEmailAddress(String emailId);


    @Query(value = "select * from tbl_student s where s.email_address = ?1",
            nativeQuery = true)
    public Student getStudentByEmailAddressNative(String emailId);


}
