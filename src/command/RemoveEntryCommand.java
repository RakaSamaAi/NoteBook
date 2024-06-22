package command;

import presenter.NotebookPresenter;
import view.NotebookView;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class RemoveEntryCommand implements Command {
    private final NotebookPresenter presenter;
    private final NotebookView view;

    public RemoveEntryCommand(NotebookPresenter presenter, NotebookView view) {
        this.presenter = presenter;
        this.view = view;
    }

    @Override
    public void execute() {
        System.out.println("Введите дату и время записи для удаления (например, 2023-06-22T19:00):");
        String dateTimeStr = view.readLine();
        LocalDateTime dateTime = LocalDateTime.parse(dateTimeStr, DateTimeFormatter.ISO_LOCAL_DATE_TIME);
        presenter.removeEntry(dateTime);
    }
}
