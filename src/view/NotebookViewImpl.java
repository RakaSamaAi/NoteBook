package view;

import command.*;
import presenter.NotebookPresenter;
import model.NotebookEntry;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class NotebookViewImpl implements NotebookView {
    private NotebookPresenter presenter;
    private final Map<String, Command> commands = new HashMap<>();
    private final Scanner scanner = new Scanner(System.in);

    @Override
    public void setPresenter(NotebookPresenter presenter) {
        this.presenter = presenter;
        initCommands();
    }

    private void initCommands() {
        commands.put("add", new AddEntryCommand(presenter, this));
        commands.put("remove", new RemoveEntryCommand(presenter, this));
        commands.put("show", new ShowEntriesCommand(presenter));
        commands.put("show_day", new ShowEntriesForDayCommand(presenter, this));
        commands.put("save", new SaveNotebookCommand(presenter, this));
        commands.put("load", new LoadNotebookCommand(presenter, this));
    }

    @Override
    public void start() {
        while (true) {
            System.out.println("Введите команду (add, remove, show, show_day, show_week, save, load, exit):");
            String command = readLine();
            if ("exit".equalsIgnoreCase(command)) {
                break;
            }
            Command cmd = commands.get(command.toLowerCase());
            if (cmd != null) {
                cmd.execute();
            } else {
                System.out.println("Неизвестная команда: " + command);
            }
        }
    }

    @Override
    public void displayEntries(List<NotebookEntry> entries) {
        entries.forEach(System.out::println);
    }

    @Override
    public void displayMessage(String message) {
        System.out.println(message);
    }

    @Override
    public String readLine() {
        return scanner.nextLine();
    }
}







