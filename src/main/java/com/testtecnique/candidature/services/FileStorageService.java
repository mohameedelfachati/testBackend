package com.testtecnique.candidature.services;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface FileStorageService {
    void save(MultipartFile file, String path, String fileName) throws IOException;
}
