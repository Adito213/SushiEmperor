package com.SushiEmperor.SushiEmperor.entities;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.Period;

@Entity
@Table(name = "users")
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column()
    private String firstName;
    private String lastName;
    private String email;
    private Long number;
    private LocalDate dateofbirth;

    @Transient
    private Integer age;

    public Users() {
    }

    public Users(String firstName, String lastName, String email, Long number, LocalDate dateofbirth){
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.number = number;
        this.dateofbirth = dateofbirth;
    }

    public Long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getNumber() {
        return number;
    }

    public void setNumber(Long number) {
        this.number = number;
    }

    public LocalDate getDateofbirth() {
        return dateofbirth;
    }

    public void setDateofbirth(LocalDate dateofbirth) {
        this.dateofbirth = dateofbirth;
    }

    public Integer getAge() {
        return Period.between(this.dateofbirth, LocalDate.now()).getYears();
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
