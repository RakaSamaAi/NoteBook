package main;
import model.NotebookModel;
import model.NotebookModelImpl;
import presenter.NotebookPresenter;
import presenter.NotebookPresenterImpl;
import view.NotebookView;
import view.NotebookViewImpl;

public class Main {
    public static void main(String[] args) {
        NotebookModel model = new NotebookModelImpl();
        NotebookView view = new NotebookViewImpl();
        NotebookPresenter presenter = new NotebookPresenterImpl(model, view);
        view.start();
    }
}



