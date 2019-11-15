package com.techncat.quantum.app.file_server.service;

import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Path;
import java.util.stream.Stream;

public interface StorageService {
    void init();

    String store(MultipartFile file);

    Stream<Path> loadAll();

    Path load(String filename);

    Resource loadAsResource(String filename);

    void deleteAll();

    class StorageException extends RuntimeException {

        public StorageException(String message) {
            super(message);
        }

        public StorageException(String message, Throwable cause) {
            super(message, cause);
        }
    }
    class StorageFileNotFoundException extends StorageException {

        public StorageFileNotFoundException(String message) {
            super(message);
        }

        public StorageFileNotFoundException(String message, Throwable cause) {
            super(message, cause);
        }
    }
}
