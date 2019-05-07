package com.quanlyquancafe.utils;

import org.apache.commons.lang.StringUtils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class UploadFileUtil {
    public final String root = "C:/usr/var";

    public boolean writeOrUpdate(byte[] bytes, String path) {
        File file = new File(StringUtils.substringBeforeLast(root + path, "/"));
        if (!file.exists()) {
            file.mkdir();
        }
        try(FileOutputStream fileOutputStream = new FileOutputStream(new File(root + path))) {
            fileOutputStream.write(bytes);//ghi file
            return true;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return  false;
    }
}
