package CoreJavaLesson3Task1;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;

public class Main {

    public static void main(String[] args) {
        String[] pathToFile = {
                "D://GamesJava/src",
                "D://GamesJava/res",
                "D://GamesJava/savegames",
                "D://GamesJava/temp",
                "D://GamesJava/src/main",
                "D://GamesJava/src/test",
                "D://GamesJava/res/drawables",
                "D://GamesJava/res/vectors",
                "D://GamesJava/res/icons"};
        String[] fileName = {
                "D://GamesJava/src/main//Main.java",
                "D://GamesJava/src/main//Utils.java",
                "D://GamesJava/temp//temp.txt"};
        StringBuilder log = new StringBuilder();


        for (int i = 0; i < pathToFile.length; i++) {
            File dir = new File(pathToFile[i]);
            if (dir.mkdir()) {
                log.append(dir.toPath() + " - директория создана успешно\r\n");
            } else if (Files.exists(dir.toPath())) {
            } else log.append(dir.toPath() + " - ошибка создания директории\r\n");
        }

        for (int i = 0; i < fileName.length; i++) {
            File newFile = new File(fileName[i]);
            try {
                if (newFile.createNewFile())
                    log.append(newFile.toPath() + " - файл создан успешно\r\n");
            } catch (IOException e) {
                log.append(newFile.toPath() + " - ошибка создания файла\r\n");
                System.out.println(e.getMessage());
            }
        }

        try (FileWriter writeLog = new FileWriter(fileName[2], true)) {
            writeLog.write(log.toString());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
