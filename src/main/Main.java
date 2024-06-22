package main;

import javax.swing.*;
import model.NotebookModel;
import model.NotebookModelImpl;
import view.NotebookViewImpl;
import presenter.NotebookPresenter;
import presenter.NotebookPresenterImpl;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                NotebookModel model = new NotebookModelImpl();
                NotebookViewImpl view = new NotebookViewImpl();
                NotebookPresenter presenter = new NotebookPresenterImpl(model, view);
                view.setVisible(true);
            }
        });
    }
}

