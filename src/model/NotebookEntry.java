package model;

import java.time.LocalDateTime;

public class NotebookEntry {
    private LocalDateTime dateTime;
    private String description;

    public NotebookEntry(LocalDateTime dateTime, String description) {
        this.dateTime = dateTime;
        this.description = description;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public String getDescription() {
        return description;
    }
}



