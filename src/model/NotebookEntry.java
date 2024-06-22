package model;

import java.io.Serializable;
import java.time.LocalDateTime;

public class NotebookEntry implements Serializable {
    private static final long serialVersionUID = 1L;
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

    @Override
    public String toString() {
        return dateTime + " - " + description;
    }
}




