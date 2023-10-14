package com.chatApp.entities.concretes;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Table(name = "mail_verification_users")
public class MailVerificationUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "mail_verification_uers_id")
    private int id;

    @Column(name = "code")
    private String code;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;
}
