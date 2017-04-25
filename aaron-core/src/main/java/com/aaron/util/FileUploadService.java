package com.aaron.util;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.util.UUID;

/**
 * Created by panzhuowen on 2016/4/27 001.
 */
@Service
public class FileUploadService {


    @Value("${fileUploadPath}")
    private String fileUploadPath;

    @Value("${httpPath}")
    private String httpPath;

    public String upload(HttpServletRequest request, String path, String suffix, InputStream inputStream) {
        String basePath = request.getSession().getServletContext().getRealPath("/" + fileUploadPath + "/");
        String filePath = basePath + "/" + path;
        UUID uuid = UUID.randomUUID();
        String fileName = uuid.toString() + "." + suffix;
        isExist(filePath);
        try {
            FileOutputStream outputStream = new FileOutputStream(filePath + "/" + fileName);
            byte[] bytes = new byte[1024];
            int length = 0;
            while ((length = (inputStream.read(bytes))) != -1) {
                outputStream.write(bytes, 0, length);
            }
            outputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
//        return httpPath +  fileUploadPath + "/" + path + "/" + fileName;
        return fileName;
    }

    private void isExist(String path) {
        File file = new File(path);
        if (!file.exists()) {
            file.mkdirs();
        }
    }

    public boolean deleteFile(String path) {
        File file = new File(path);
        if (file.exists()) {
            file.delete();
            return true;
        }
        return false;
    }

    public FileInputStream downloadFile(String path) throws FileNotFoundException {
        return new FileInputStream(new File(path));
    }

}
