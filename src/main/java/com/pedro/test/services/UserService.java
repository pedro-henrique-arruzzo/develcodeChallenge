package com.pedro.test.services;

import com.pedro.test.entities.User;
import com.pedro.test.repositories.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDate;

@Service
public class UserService {

    private final UserRepository repository;
    private final FilesStorageService storageService;

    public UserService(UserRepository repository, FilesStorageService storageService) {
        this.repository = repository;
        this.storageService = storageService;
    }

    public User save(String name, LocalDate birthDate, MultipartFile picture) {
        User user = new User(name, birthDate);
        user.setPicturePath(storageService.save(picture, user.getCode()));
        return repository.save(user);
    }
}
