package com.example.student_management_system.student;

import com.example.student_management_system.course.Course;

import javax.persistence.*;
import java.util.Collection;

@Entity(name = "Student")
@Table(
        name = "student",
        uniqueConstraints = {
                @UniqueConstraint(name = "student_email_unique", columnNames = "email"),
                @UniqueConstraint(name = "student_username_unique", columnNames = "username")
        }
)
public class Student {

    @Id
//    @SequenceGenerator(
//            name = "student_sequence",
//            sequenceName = "student_sequence",
//            allocationSize = 1
//    )
    @GeneratedValue(
            strategy = GenerationType.AUTO
//            generator = "student_sequence"
    )
    private Long id;
    @Column(
            name = "Username",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String username;
    @Column(
            name = "email",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String email;
    @Column(
            name = "password",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String password;

    /**
     * FetchType.EAGER -> loads it together with the Student fields
     * (all course data will be loaded)
     */
    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(
            name = "student_course",
            joinColumns = @JoinColumn(
                    name = "id", referencedColumnName = "id"
            ),
            inverseJoinColumns = @JoinColumn(
                    name = "student_id", referencedColumnName = "id"
            )
    )
    private Collection<Course> courses;

    public Student(String userName, String email, String password, Collection<Course> courses) {
        this.username = userName;
        this.email = email;
        this.password = password;
        this.courses = courses;
    }

    public Student() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
