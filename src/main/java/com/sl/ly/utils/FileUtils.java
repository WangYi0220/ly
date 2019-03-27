package com.sl.ly.utils;

import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

public class FileUtils {
    private static final String PATH = "D:/zhImg/";

    public static String fileUP(MultipartFile file, String pathPrefix) {
        if (file == null || file.isEmpty()) return null;
        try {
            String fileName = file.getOriginalFilename();
            int i = fileName.lastIndexOf(".");
            String suffix = fileName.substring(i);
            String path = PATH + pathPrefix;
            String newFileName = UUIDUtils.getUUID() + suffix;
            File targetFile = new File(path, newFileName);
            file.transferTo(targetFile);
            return pathPrefix + newFileName;
        } catch (IOException e) {
            e.printStackTrace();
            return "img 500";
        }

    }
}
