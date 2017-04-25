package com.aaron.util;

import java.io.*;

/**
 * .
 * Creator:aaron_yong
 * Date:2017/3/20
 * Time:8:21
 */
public class FileUtil {
    /**
     *把byte文件转换成MB大小文件
     * @param byteFile
     * @return
     */
    public  static String getFileMB(long byteFile) {
        if (byteFile == 0) {
            return "0MB";
        }
        long mb = 1024 * 1024;
        return "" + byteFile / mb + "MB";
    }

    // 保存文件到指定路径
    private File saveFileFromInputStream(InputStream stream, String path, String filename) {
        // 检查保存上传文件的文件夹是否存在
        File dirFile = new File(path);
        if (!dirFile.exists()) {
            dirFile.mkdir();
        }
        File file = null;
        FileOutputStream fs = null;
        try {
            file = new File(path + "/" + filename);
            fs = new FileOutputStream(file);
            byte[] buffer = new byte[1024 * 1024];
            int bytesum = 0;
            int byteread = 0;
            while ((byteread = stream.read(buffer)) != -1) {
                bytesum += byteread;
                fs.write(buffer, 0, byteread);
                fs.flush();
            }
            fs.close();
            stream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fs != null) {
                    fs.close();
                }
                if (stream != null) {
                    stream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return file;
    }
}

