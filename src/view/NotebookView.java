package view;

import presenter.NotebookPresenter;
import model.NotebookEntry;

import java.util.List;

public interface NotebookView {
    void setPresenter(NotebookPresenter presenter);
    void start();
    void displayEntries(List<NotebookEntry> entries);
    void displayMessage(String message);
    String readLine();
}


