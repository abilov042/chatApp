package com.chatApp.api.controllers;

import com.chatApp.business.abstractes.UserService;
import com.chatApp.core.untilitues.result.DataResult;
import com.chatApp.core.untilitues.result.ErrorDataResult;
import com.chatApp.core.untilitues.result.Result;
import com.chatApp.entities.concretes.User;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/user")
@CrossOrigin
@AllArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping("/add")
    public ResponseEntity<?> add(@Valid @RequestBody User user){

        return ResponseEntity.ok(this.userService.add(user));
    }

    @GetMapping("/getall")
    public DataResult<List<User>> getAll(){

        return this.userService.getAll();
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    ErrorDataResult<Object> handleValidationException(MethodArgumentNotValidException exceptions){
        Map<String, String> validationErrors = new HashMap<String, String>();
        for(FieldError fieldError : exceptions.getBindingResult().getFieldErrors()) {
            validationErrors.put(fieldError.getField(), fieldError.getDefaultMessage());
        }

        ErrorDataResult<Object> error = new ErrorDataResult<Object>(validationErrors,"Error");

        return error;
    }
}
