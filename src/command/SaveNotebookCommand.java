package command;

import presenter.NotebookPresenter;
import view.NotebookView;

public class SaveNotebookCommand implements Command {
    private final NotebookPresenter presenter;
    private final NotebookView view;

    public SaveNotebookCommand(NotebookPresenter presenter, NotebookView view) {
        this.presenter = presenter;
        this.view = view;
    }

    @Override
    public void execute() {
        System.out.println("Введите имя файла для сохранения:");
        String filename = view.readLine();
        presenter.saveNotebook(filename);
    }
}
