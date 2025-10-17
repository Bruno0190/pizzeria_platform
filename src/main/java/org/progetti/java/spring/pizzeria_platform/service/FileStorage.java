package org.progetti.java.spring.pizzeria_platform.service;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import java.nio.file.*;
import java.io.*;

@Service
public class FileStorage {
    
    MultipartFile file;

    public FileStorage(MultipartFile file) {
        this.file = file;
    }

    public String storeFile(MultipartFile file){

        if(file.isEmpty()) {
            return null;
        } else {
            String directoryPath = "C:/Users/black/Desktop/Boolean/esercizi/pizzeria_platform/src/main/resources/static/images/";
            String filePath = directoryPath + file.getOriginalFilename();
            try {
                Files.copy(file.getInputStream(), Paths.get(filePath));
            } catch (IOException e) {
                return null; // o gestire l'errore
            }

        }

        return "/images/" + file.getOriginalFilename();  // ← URL per il browser
       
    }

}
