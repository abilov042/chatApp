package com.chatApp.api.controllers;

import com.chatApp.business.abstractes.UserService;
import com.chatApp.core.untilitues.result.DataResult;
import com.chatApp.entities.concretes.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/user")
@CrossOrigin
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/getall")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<DataResult<List<User>>> getAll(){

        return ResponseEntity.ok(this.userService.getAll());
    }

    @GetMapping("test")
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<String> getTest(){

        return ResponseEntity.ok("Test");
    }

}

