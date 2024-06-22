package command;

import presenter.NotebookPresenter;
import view.NotebookView;

public class LoadNotebookCommand implements Command {
    private final NotebookPresenter presenter;
    private final NotebookView view;

    public LoadNotebookCommand(NotebookPresenter presenter, NotebookView view) {
        this.presenter = presenter;
        this.view = view;
    }

    @Override
    public void execute() {
        System.out.println("Введите имя файла для загрузки:");
        String filename = view.readLine();
        presenter.loadNotebook(filename);
    }
}

