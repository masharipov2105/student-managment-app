package com.masharipov2105.systems;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Main {
    private static final ObjectMapper objectMapper = new ObjectMapper()
            .registerModule(new JavaTimeModule());

    private static final String DATA_FILE = "data.json";
    private static List<String> items = new ArrayList<>();

    public static void main(String[] args) {
        loadData();

        System.out.println("Console App ishga tushdi!");
        System.out.println("Paket: com.masharipov2105.systems");
        System.out.println("Joriy elementlar soni: " + items.size());

        items.add("Yangi element");
        items.add("Yana bir element");

        saveData();
        System.out.println("Ma'lumotlar saqlandi. Elementlar soni: " + items.size());
    }

    private static void loadData() {
        File file = new File(DATA_FILE);
        if (!file.exists()) {
            System.out.println("data.json mavjud emas, yangi fayl yaratiladi");
            return;
        }

        try {
            items = objectMapper.readValue(file, List.class);
            System.out.println("data.json dan yuklandi: " + items.size() + " ta element");
        } catch (IOException e) {
            System.err.println("Yuklashda xatolik: " + e.getMessage());
            items = new ArrayList<>();
        }
    }

    private static void saveData() {
        try {
            objectMapper.writerWithDefaultPrettyPrinter()
                    .writeValue(Paths.get(DATA_FILE).toFile(), items);
        } catch (IOException e) {
            System.err.println("Saqlashda xatolik: " + e.getMessage());
        }
    }
}
