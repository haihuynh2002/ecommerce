package com.example.ecommerce.util;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.web.multipart.MultipartFile;

public class ImageUtil {

    public static String saveImage(MultipartFile file, String path, String root) {
        try {
            String fileName = file.getOriginalFilename();
            Path fileNameAndPath = Paths.get(path, fileName);
            Files.write(fileNameAndPath, file.getBytes());
            return root + fileName;
        } catch(Exception e) {
            System.out.println(e);
        }
        return null;
    }
}
