package com.chatApp.entities.concretes;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "email")
    @Email
    @NotBlank
    @NotNull
    private String email;

    @Column(name = "user_name")
    @Email
    @NotBlank
    @NotNull
    private String userName;

    @Column(name = "passwrod")
    @NotBlank
    @NotNull
    private String passwrod;

    @Column(name = "first_name")
    @NotBlank
    @NotNull
    private String firstName;

    @Column(name = "last_name")
    @NotBlank
    @NotNull
    private String lastName;
}
