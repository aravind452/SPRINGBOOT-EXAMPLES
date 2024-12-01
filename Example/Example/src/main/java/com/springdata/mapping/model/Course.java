package com.springdata.mapping.model;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString(exclude = "courseMaterial")
public class Course {

    @Id
    @SequenceGenerator(name = "course_sequence",
            sequenceName = "course_sequence",
            allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "course_sequence")
    private Long courseId;
    private String title;
    private Integer credit;

    @OneToOne(cascade = CascadeType.ALL,
            optional = false)
    @JoinColumn(name = "course_material_id")
    private CourseMaterial courseMaterial;


    // Many to one
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "teacher_id",

            referencedColumnName = "teacherId")
    private Teacher teacher;

}
