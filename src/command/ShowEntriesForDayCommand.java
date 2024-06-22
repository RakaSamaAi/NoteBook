package command;

import presenter.NotebookPresenter;
import view.NotebookView;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class ShowEntriesForDayCommand implements Command {
    private final NotebookPresenter presenter;
    private final NotebookView view;

    public ShowEntriesForDayCommand(NotebookPresenter presenter, NotebookView view) {
        this.presenter = presenter;
        this.view = view;
    }

    @Override
    public void execute() {
        System.out.println("Введите дату (например, 2023-06-22):");
        String dateStr = view.readLine();
        LocalDate date = LocalDate.parse(dateStr, DateTimeFormatter.ISO_LOCAL_DATE);
        presenter.showEntriesForDay(date);
    }
}

