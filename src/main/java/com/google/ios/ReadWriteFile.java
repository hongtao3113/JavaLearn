package com.google.ios;


import org.apache.commons.lang3.StringUtils;

import java.io.*;

public class ReadWriteFile {

    public static void readFileContent(String filePath) {
        FileInputStream fileInputStream = null;
        BufferedReader bufferedReader = null;
        try {
            fileInputStream = new FileInputStream(filePath);
            bufferedReader = new BufferedReader(new InputStreamReader(fileInputStream));
            StringBuffer content = new StringBuffer();
            String line = bufferedReader.readLine();
            content.append(line).append("\n");
            while (StringUtils.isNotBlank(line = bufferedReader.readLine())) {
                content.append(line).append("\n");
            }
            System.out.println(content);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                bufferedReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                fileInputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void writeFile(String filePath, String content) {
        FileOutputStream fileOutputStream = null;
        BufferedWriter bufferedWriter = null;
        try {
            fileOutputStream = new FileOutputStream(new File(filePath));
            bufferedWriter = new BufferedWriter(new OutputStreamWriter(fileOutputStream));
            bufferedWriter.write(content);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (bufferedWriter != null) {
                try {
                    //刷新缓存区
                    bufferedWriter.flush();
                    bufferedWriter.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (fileOutputStream != null) {
                try {
                    fileOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        String filePath = "C:\\Users\\wk\\Desktop\\1.txt";
        writeFile(filePath, "Java读写文件");
        readFileContent(filePath);
    }
}
