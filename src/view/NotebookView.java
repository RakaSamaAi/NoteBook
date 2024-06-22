package view;

import model.NotebookEntry;
import presenter.NotebookPresenter;

import java.util.List;

public interface NotebookView {
    void displayEntries(List<NotebookEntry> entries);
    void displayMessage(String message);
    void setPresenter(NotebookPresenter presenter);
}

