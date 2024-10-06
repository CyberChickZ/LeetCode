package com.cyberchickz.leetcode;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        System.out.print("Hello and welcome!");

        createFile("wsss");
    }

    static void createFile(String className) {
        // parse类名
        className = className.replace('.', '_');
        className = className.replace(' ', '_');
        // 在当前目录创建 Java 类文件
        File file = new File(className + ".java");
        try {
            if (file.createNewFile()) {
                System.out.println("Java class file created: " + file.getName());
                // 写入基本的类定义
                FileWriter writer = new FileWriter(file);
                writer.write("public class " + className + " {\n");
                writer.write("}\n");
                writer.close();
                System.out.println("Successfully wrote to the file.");
            } else {
                System.out.println("File already exists.");
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
        }
    }
}