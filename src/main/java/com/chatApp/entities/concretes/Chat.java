package com.chatApp.entities.concretes;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "chat")
public class Chat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @ManyToOne
    @JoinColumn(name = "sender_id")
    private User senderUser;

    @ManyToOne
    @JoinColumn(name = "receiver_id")
    private User receiverUser;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

//    @OneToMany
//    private List<Massage> massage;



}
