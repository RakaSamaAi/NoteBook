package model;

import java.io.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class NotebookModelImpl implements NotebookModel {
    private List<NotebookEntry> entries = new ArrayList<>();

    @Override
    public void addEntry(LocalDateTime dateTime, String description) {
        entries.add(new NotebookEntry(dateTime, description));
    }

    @Override
    public void removeEntry(LocalDateTime dateTime) {
        entries.removeIf(entry -> entry.getDateTime().equals(dateTime));
    }

    @Override
    public List<NotebookEntry> getEntries() {
        return new ArrayList<>(entries);
    }

    @Override
    public List<NotebookEntry> getEntriesForDay(LocalDate date) {
        return entries.stream()
                .filter(entry -> entry.getDateTime().toLocalDate().equals(date))
                .collect(Collectors.toList());
    }

    @Override
    public List<NotebookEntry> getEntriesForWeek(LocalDate startOfWeek) {
        LocalDate endOfWeek = startOfWeek.plusDays(6);
        return entries.stream()
                .filter(entry -> {
                    LocalDate entryDate = entry.getDateTime().toLocalDate();
                    return (entryDate.isEqual(startOfWeek) || entryDate.isAfter(startOfWeek)) &&
                            (entryDate.isEqual(endOfWeek) || entryDate.isBefore(endOfWeek));
                })
                .collect(Collectors.toList());
    }

    @Override
    public void saveToFile(String filename) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
            oos.writeObject(entries);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void loadFromFile(String filename) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
            entries = (List<NotebookEntry>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}



