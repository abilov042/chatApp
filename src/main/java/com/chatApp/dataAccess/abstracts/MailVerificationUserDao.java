package com.chatApp.dataAccess.abstracts;

import com.chatApp.entities.concretes.MailVerificationUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface MailVerificationUserDao  extends JpaRepository<MailVerificationUser, Integer> {
    MailVerificationUser findByUser_Id(int id);
    boolean existsByUser_Id(int id);
    @Query("SELECT id from MailVerificationUser where user.id=:id")
    int findIdByUser_id(int id);
}
