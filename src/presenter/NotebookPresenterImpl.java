package presenter;

import model.NotebookModel;
import view.NotebookView;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class NotebookPresenterImpl implements NotebookPresenter {
    private final NotebookModel model;
    private final NotebookView view;

    public NotebookPresenterImpl(NotebookModel model, NotebookView view) {
        this.model = model;
        this.view = view;
        this.view.setPresenter(this);
    }

    @Override
    public void addEntry(LocalDateTime dateTime, String description) {
        model.addEntry(dateTime, description);
        view.displayEntries(model.getEntries());
    }

    @Override
    public void removeEntry(LocalDateTime dateTime) {
        model.removeEntry(dateTime);
        view.displayEntries(model.getEntries());
    }

    @Override
    public void showEntries() {
        view.displayEntries(model.getEntries());
    }

    @Override
    public void showEntriesForDay(LocalDate date) {
        view.displayEntries(model.getEntriesForDay(date));
    }

    @Override
    public void showEntriesForWeek(LocalDate startOfWeek) {
        view.displayEntries(model.getEntriesForWeek(startOfWeek));
    }

    @Override
    public void saveNotebook(String filename) {
        model.saveToFile(filename);
        view.displayMessage("Записная книжка сохранена в файл: " + filename);
    }

    @Override
    public void loadNotebook(String filename) {
        model.loadFromFile(filename);
        view.displayEntries(model.getEntries());
        view.displayMessage("Записная книжка загружена из файла: " + filename);
    }
}



