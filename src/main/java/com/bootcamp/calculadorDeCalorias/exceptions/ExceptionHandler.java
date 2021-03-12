package com.bootcamp.calculadorDeCalorias.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class ExceptionHandler {

    @org.springframework.web.bind.annotation.ExceptionHandler(IngredientNotFound.class)
    public ResponseEntity<ErrorDTO> handleException(IngredientNotFound e) {
        ErrorDTO error = new ErrorDTO();
        error.setName("Invalid Ingredient");
        error.setDescription("The ingredient " + e.getMessage() + " is invalid.");
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }
}
