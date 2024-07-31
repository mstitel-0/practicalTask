package com.example.practicaltask.Controllers;

import com.example.practicaltask.Models.UserNotFoundExceptionModel;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.client.HttpClientErrorException;

@RestControllerAdvice
public class ExceptionHandlerController {

    private final ObjectMapper mapper;

    public ExceptionHandlerController(ObjectMapper mapper) {
        this.mapper = mapper;
    }

    @ExceptionHandler(HttpClientErrorException.NotFound.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<?> handleUserNotFoundException(HttpClientErrorException exception) throws JsonProcessingException {
        UserNotFoundExceptionModel response = mapper.readValue(exception.getResponseBodyAsString(), UserNotFoundExceptionModel.class);
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }
}
