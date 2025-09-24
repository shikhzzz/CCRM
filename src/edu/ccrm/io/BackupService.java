package edu.ccrm.io;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class BackupService {

    public void createTimestampedBackup(Path sourceDir, Path backupRootDir) throws IOException {
        String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss"));
        Path backupDir = backupRootDir.resolve("backup_" + timestamp);
        
        Files.createDirectories(backupDir);

        try (var walk = Files.walk(sourceDir)) {
            walk.forEach(source -> {
                try {
                    Files.copy(source, backupDir.resolve(sourceDir.relativize(source)), StandardCopyOption.REPLACE_EXISTING);
                } catch (IOException e) {
                    System.err.println("Failed to copy file: " + source);
                }
            });
        }
        System.out.println("Backup created at: " + backupDir);
    }

    public long calculateSize(Path directory) throws IOException {
        return Files.walk(directory)
                    .filter(Files::isRegularFile)
                    .mapToLong(p -> {
                        try {
                            return Files.size(p);
                        } catch (IOException e) {
                            return 0L;
                        }
                    })
                    .sum();
    }
}