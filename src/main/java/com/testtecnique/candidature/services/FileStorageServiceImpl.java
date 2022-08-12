package com.testtecnique.candidature.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Date;

@Service
@Slf4j
public class FileStorageServiceImpl implements FileStorageService{
    @Override
    public void save(MultipartFile file, String path, String fileName) throws IOException {
        try {
            log.info("Saving the file ...");
            Files.copy(file.getInputStream(), Paths.get(path).resolve(fileName));
            log.info("File uploaded successfully: " +new Date().getTime()+ file.getOriginalFilename());
        } catch (Exception e) {
            throw e;
        }
    }
}
