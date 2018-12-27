package io.github.biezhi.webp;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class BaseTest {

    protected String classPath() {
        return BaseTest.class.getResource("/").getPath();
    }

    protected void deleteTempFile(String fileName) {
        try {
            Files.delete(Paths.get(fileName));
        } catch (IOException e) {
            System.out.println("delete file "+ fileName +" fail, err:" + e.getMessage());
        }
    }

}
