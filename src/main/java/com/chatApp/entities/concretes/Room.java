package com.chatApp.entities.concretes;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "rooms")
public class Room {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="room_id")
    private int id;

    @Column(name = "room_name")
    private String roomName;


//    @OneToOne
//    @JoinColumn(name = "message_id")
//    private Message  message;

//    @ManyToMany(fetch = FetchType.LAZY)
//    @JoinTable(name = "room_users",
//            joinColumns = @JoinColumn(name = "room_id"),
//            inverseJoinColumns = @JoinColumn(name = "user_id"))
//    private List<User> users;

}
