package com.victoria.parabank.utils;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class FileUtils {
    public String readFile(String path) {
        try (BufferedReader bd = new BufferedReader(new InputStreamReader(new FileInputStream(path)))) {
            StringBuilder sb=new StringBuilder();
            String line;
            while ((line=bd.readLine()) !=null){
                sb.append(line);
                sb.append(System.lineSeparator());
            }
            return sb.toString();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}