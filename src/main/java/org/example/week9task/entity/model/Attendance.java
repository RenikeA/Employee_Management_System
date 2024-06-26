package org.example.week9task.entity.model;

import jakarta.persistence.*;
import org.example.week9task.entity.enums.Present;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "attendances_tbl")
public class Attendance extends BaseClass {

    @Column(name = "name")
    private String name;

    @Column(name = "date")
    private LocalDate date;

    @Column(name = "present")
    @Enumerated(EnumType.STRING)
    private Present present;

    @Column(name = "position")
    private String position;

//    @ManyToOne
//    @JoinColumn(name = "employee_id", nullable = false)
//    private Employee employee;

    // Constructors
    public Attendance() {
    }

    public Attendance(Long employeeId, LocalDate date, Present present, Long id, LocalDateTime createAt, LocalDateTime updateAt, Employee employee) {
        super(id, createAt, updateAt);
        this.date = date;
        this.present = present;
      //  this.employee = employee;
    }

    // Getters and setters



    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Present getPresent() {
        return present;
    }

    public void setPresent(Present present) {
        this.present = present;
    }


    //    public Employee getEmployee() {
//        return employee;
//    }
//
//    public void setEmployee(Employee employee) {
//        this.employee = employee;
//    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}


/**
 * 1. create a base class
 * 2. extend your baseclass to your Employee and Attendance class, leave class
 * 3. add fields to your employee and attendance class
 * 4. add getter and setters, and constructors manually, do not use lombok
 */