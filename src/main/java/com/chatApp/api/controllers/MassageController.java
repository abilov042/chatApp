package com.chatApp.api.controllers;

import com.chatApp.business.abstractes.MassageService;
import com.chatApp.core.untilitues.result.DataResult;
import com.chatApp.core.untilitues.result.ErrorDataResult;
import com.chatApp.entities.concretes.Message;
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
@RequestMapping("/api/massage")
@CrossOrigin
@AllArgsConstructor
public class MassageController {
    private final MassageService massageService;

    @PostMapping("/add")
    public ResponseEntity<?> add(Message message){

        return ResponseEntity.ok(this.massageService.add(message));
    }

    @GetMapping("/getall")
    public DataResult<List<Message>> getAll(){

        return this.massageService.getAll();
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
