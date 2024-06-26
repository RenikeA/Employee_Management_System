package org.example.week9task.entity.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "employees_tbl")
public class Employee extends BaseClass {

    @Column(name = "name")
    private String name;

    @Column(name = "position")
    private String position;

    @Column(name = "salary")
    private Double salary;

    @Column(name = "email", unique = true, nullable = false)
    private String email;

//    @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL, orphanRemoval = true)
//    private List<Attendance> attendances;

//    @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL, orphanRemoval = true)
//    private List<Leave> leaves;

    // Constructors
    public Employee() {
    }

    public Employee(Long id, LocalDateTime createAt, LocalDateTime updateAt, String name, String position, Double salary, String email) {
        super(id, createAt, updateAt);
        this.name = name;
        this.position = position;
        this.salary = salary;
        this.email = email;
       // this.attendances = attendances;
       // this.leaves = leaves;
    }

    // Getters and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

//    public List<Attendance> getAttendances() {
//        return attendances;
//    }
//
//    public void setAttendances(List<Attendance> attendances) {
//        this.attendances = attendances;
//    }

//    public List<Leave> getLeaves() {
//        return leaves;
//    }
//
//    public void setLeaves(List<Leave> leaves) {
//        this.leaves = leaves;
//    }
}




//@Entity
//@Table(name = "student_tbl")
//public class Student {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//
//    private String firstName;
//
//    private String lastName;
//
//    private String email;



//public class Employee {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//
//    private String name;
//    private String position;
//    private Double salary;
//
//    @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL, orphanRemoval = true)
//    private List<Attendance> attendances;
//
//    @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL, orphanRemoval = true)
//    private List<Leave> leaves;
//
//    public Employee() {
//
//    }
//
//
//    public Employee(Long id, String name, String position, Double salary, List<Attendance> attendances, List<Leave> leaves) {
//        this.id = id;
//        this.name = name;
//        this.position = position;
//        this.salary = salary;
//        this.attendances = attendances;
//        this.leaves = leaves;
//    }

