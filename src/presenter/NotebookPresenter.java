package presenter;

import java.time.LocalDate;
import java.time.LocalDateTime;

public interface NotebookPresenter {
    void addEntry(LocalDateTime dateTime, String description);
    void removeEntry(LocalDateTime dateTime);
    void showEntries();
    void showEntriesForDay(LocalDate date);
    void showEntriesForWeek(LocalDate startOfWeek);
    void saveNotebook(String filename);
    void loadNotebook(String filename);
}


