package com.superkind.lamda.file;

import java.io.*;

public class FileServiceImpl {
    public void fileHandler(String fileUrl,ConsumerFile consumerFile){
        try {
            //创建文件读取流
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(fileUrl)));

            //定义行变量
            String line = null;

            StringBuffer stringBuffer = new StringBuffer();

            //循环读取文件内容
            while ((line = bufferedReader.readLine()) != null){
                stringBuffer.append(line + "\n");
            }
            consumerFile.fileHanlder(stringBuffer.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void fileHandler2(String fileUrl,ConsumerFile consumerFile){
        try (
                FileInputStream fileInputStream = new FileInputStream(fileUrl);
                InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
                BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

                ){
            //定义行变量
            String line = null;

            StringBuffer stringBuffer = new StringBuffer();

            //循环读取文件内容
            while ((line = bufferedReader.readLine()) != null){
                stringBuffer.append(line + "\n");
            }
            consumerFile.fileHanlder(stringBuffer.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
