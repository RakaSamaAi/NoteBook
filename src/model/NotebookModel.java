package model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public interface NotebookModel {
    void addEntry(LocalDateTime dateTime, String description);
    void removeEntry(LocalDateTime dateTime);
    List<NotebookEntry> getEntries();
    List<NotebookEntry> getEntriesForDay(LocalDate date);
    List<NotebookEntry> getEntriesForWeek(LocalDate startOfWeek);
    void saveToFile(String filename);
    void loadFromFile(String filename);
}


