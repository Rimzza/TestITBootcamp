package com.nikita.testtask.models;


import com.nikita.testtask.roles.Role;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "surname")
    @Size(message = "Surname should be from 2 to 40", min = 2, max = 40)
    @Pattern(regexp = "[a-zA-Z]{2,40}", message = "Invalid surname")
    private String surname;

    @Column(name = "name")
    @Size(message = "Name should be from 2 to 20", min = 2, max = 20)
    @Pattern(regexp = "[a-zA-Z]{2,40}", message = "Invalid name")
    private String name;

    @Column(name = "patronymic")
    @Size(message = "Patronymic should be from 2 to 40", min = 2, max = 40)
    @Pattern(regexp = "[a-zA-Z]{2,40}", message = "Invalid patronymic")
    private String patronymic;

    @Enumerated(EnumType.STRING)
    @Column(name = "role")
    private Role role;

    @Column(name = "email")
    @Email(message = "must be a well-formed email address")
    private String email;
    public User() {

    }

    public User(String surname, String name, String patronymic, Role role, String email) {
        this.surname = surname;
        this.name = name;
        this.patronymic = patronymic;
        this.role = role;
        this.email=email;
    }


    public int getId() {
        return id;

    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
