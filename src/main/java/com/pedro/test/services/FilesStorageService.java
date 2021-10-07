package com.pedro.test.services;

import com.pedro.test.entities.User;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Objects;
import java.util.UUID;

@Service
public class FilesStorageService {

    public String save(MultipartFile file, UUID codeUser) {
        try {
            Path root = Paths.get("uploads/" + codeUser);
            Files.createDirectories(root);

            // Imagem apenas em memoria - Nesse momento ele seta o path da imagem
            Path resolve = root.resolve(Objects.requireNonNull(file.getOriginalFilename()));

            // Transforma essa imagem em memoria em um ARQUIVO atraves dos bytes
            Files.copy(file.getInputStream(), resolve);
            return resolve.toString();
        } catch (Exception e) {
            throw new RuntimeException("Could not store the file. Error: " + e.getMessage());
        }
    }

}