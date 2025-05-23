package com.example.demo.Exception;

import com.example.demo.model.Tatoueur;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class NotFoundException extends Exception {
    public NotFoundException(String message) {
        super(message);
    }

}