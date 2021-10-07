package com.pedro.test.controllers;

import com.pedro.test.entities.User;
import com.pedro.test.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDate;

@RestController
@RequestMapping("users")
public class UserController {

    private final UserService service;

    // Injecao de Dependencia
    public UserController(UserService service) {
        this.service = service;
    }

    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<User> create(@RequestParam("name") String name,
                                       @RequestParam("birthDate") String birthDate,
                                       @RequestParam("file") MultipartFile file) {
        try {
            User persistedUser = service.save(name, LocalDate.parse(birthDate), file);
            return ResponseEntity.ok(persistedUser);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }
}
