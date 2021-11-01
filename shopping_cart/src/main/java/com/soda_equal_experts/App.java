package com.soda_equal_experts;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * Prints the README file.
 */
public class App {
    
    /** 
     * @param args
     * @throws IOException
     */
    public static void main(final String[] args) throws IOException {
        final String currentPath = new java.io.File(".").getCanonicalPath();
        System.out.println("Current dir:" + currentPath + "\n");

        final File file = new File("README.md");
        final FileInputStream fis = new FileInputStream(file);

        int oneByte;
        while ((oneByte = fis.read()) != -1) {
            System.out.write(oneByte);
        }
        System.out.flush();
        fis.close();
    }
}
