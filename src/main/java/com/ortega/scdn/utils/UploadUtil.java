package com.ortega.scdn.utils;

import java.util.UUID;

public class UploadUtil {

    public static String getResourcePath() {
        return System.getProperty("user.dir") + "/src/main/resources/songs/";
    }

    public static String generateUniqueSongName(String fileName) {

        // generate uuid and convert it in String
        String uniqueUUID = UUID.randomUUID().toString();
        // split file in two part (name and extension)
        String[] parts = fileName.split("\\.");
        // get extension of current file
        String extension = parts[parts.length - 1];

        // concatenate uniqueUUID and extension
        return uniqueUUID + "." + extension;

    }

}
