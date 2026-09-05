# student-managment-app

Maven asosidagi Console App (JSON + JUnit + Shade)

## Ishga tushirish (3 usul)

### 1. Maven exec plugin bilan
```bash
cd student-managment-app
mvn exec:java
```

### 2. Shade JAR ni ishga tushirish (barcha dependency lar bilan)
```bash
mvn clean package
java -jar target/student-managment-app-1.0-SNAPSHOT.jar
```

### 3. Faqat kompilyatsiya qilish
```bash
mvn clean compile
```

## Testlarni ishga tushirish
```bash
mvn test
```

## Loyiha tuzilishi
```
student-managment-app/
├── pom.xml
├── README.md
├── .gitignore
├── data.json           # Ish vaqtida yaratiladi
├── screenshots/         # Skrinshotlar uchun
└── src/
    ├── main/
    │   ├── java/com/masharipov2105/systems/
    │   │   └── Main.java
    │   └── resources/
    └── test/
        ├── java/com/masharipov2105/systems/
        │   └── MainTest.java
        └── resources/
```

## Bog'liqliklar
- Jackson (JSON)
- JUnit 5

## Muallif
com.masharipov2105.systems
