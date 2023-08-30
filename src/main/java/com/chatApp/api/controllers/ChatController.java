package com.chatApp.api.controllers;

import com.chatApp.business.abstractes.ChatService;
import com.chatApp.core.untilitues.result.DataResult;
import com.chatApp.core.untilitues.result.ErrorDataResult;
import com.chatApp.entities.concretes.Chat;
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
@RequestMapping("/api/chat")
@CrossOrigin
@AllArgsConstructor
public class ChatController {

    private final ChatService chatService;

    @PostMapping("/add")
    public ResponseEntity<?> add(@Valid @RequestBody Chat chat){

        return ResponseEntity.ok(this.chatService.add(chat));
    }

    @GetMapping("/getall")
    public DataResult<List<Chat>> getAll(){

        return this.chatService.getAll();
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
