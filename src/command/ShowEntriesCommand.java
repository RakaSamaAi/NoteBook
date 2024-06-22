package command;

import presenter.NotebookPresenter;

public class ShowEntriesCommand implements Command {
    private final NotebookPresenter presenter;

    public ShowEntriesCommand(NotebookPresenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void execute() {
        presenter.showEntries();
    }
}

