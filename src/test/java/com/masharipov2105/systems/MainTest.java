package com.masharipov2105.systems;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;

public class MainTest {

    @BeforeEach
    void setUp() {
        File file = new File("data.json");
        if (file.exists()) {
            file.delete();
        }
    }

    @Test
    void testAddition() {
        assertEquals(4, 2 + 2, "2 + 2 = 4 bo'lishi kerak");
    }

    @Test
    void testDataFileCreated() {
        Main.main(new String[]{});
        File file = new File("data.json");
        assertTrue(file.exists(), "data.json fayli yaratilishi kerak");
    }

    @Test
    void testDataFileContent() throws Exception {
        Main.main(new String[]{});
        String content = new String(Files.readAllBytes(Paths.get("data.json")));
        assertTrue(content.contains("Yangi element"), "JSON da 'Yangi element' bo'lishi kerak");
        assertTrue(content.contains("Yana bir element"), "JSON da 'Yana bir element' bo'lishi kerak");
    }
}
