package view;

import model.NotebookEntry;
import presenter.NotebookPresenter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;

public class NotebookViewImpl extends JFrame implements NotebookView {
    private NotebookPresenter presenter;
    private JTextArea entriesArea;
    private JTextField dateTimeField;
    private JTextField descriptionField;
    private JTextField filenameField;

    public NotebookViewImpl() {
        setTitle("Записная книжка");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        initComponents();
    }

    private void initComponents() {
        entriesArea = new JTextArea();
        entriesArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(entriesArea);

        dateTimeField = new JTextField();
        descriptionField = new JTextField();
        filenameField = new JTextField();

        JButton addButton = new JButton("Добавить запись");
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String dateTimeStr = dateTimeField.getText();
                    String description = descriptionField.getText();
                    LocalDateTime dateTime = LocalDateTime.parse(dateTimeStr, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
                    presenter.addEntry(dateTime, description);
                    presenter.showEntries();
                } catch (DateTimeParseException ex) {
                    displayMessage("Ошибка: Неверный формат даты и времени. Используйте формат yyyy-MM-dd HH:mm.");
                }
            }
        });

        JButton showAllButton = new JButton("Показать все записи");
        showAllButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                presenter.showEntries();
            }
        });

        JButton saveButton = new JButton("Сохранить");
        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String filename = filenameField.getText();
                presenter.saveNotebook(filename);
            }
        });

        JButton loadButton = new JButton("Загрузить");
        loadButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String filename = filenameField.getText();
                presenter.loadNotebook(filename);
            }
        });

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(0, 2));
        panel.add(new JLabel("Дата и время (yyyy-MM-dd HH:mm):"));
        panel.add(dateTimeField);
        panel.add(new JLabel("Описание:"));
        panel.add(descriptionField);
        panel.add(new JLabel("Имя файла:"));
        panel.add(filenameField);
        panel.add(addButton);
        panel.add(showAllButton);
        panel.add(saveButton);
        panel.add(loadButton);

        getContentPane().add(panel, BorderLayout.NORTH);
        getContentPane().add(scrollPane, BorderLayout.CENTER);
    }

    @Override
    public void displayEntries(List<NotebookEntry> entries) {
        entriesArea.setText("");
        for (NotebookEntry entry : entries) {
            entriesArea.append(entry.getDateTime().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")) + " - " + entry.getDescription() + "\n");
        }
    }

    @Override
    public void displayMessage(String message) {
        JOptionPane.showMessageDialog(this, message);
    }

    @Override
    public void setPresenter(NotebookPresenter presenter) {
        this.presenter = presenter;
    }
}




